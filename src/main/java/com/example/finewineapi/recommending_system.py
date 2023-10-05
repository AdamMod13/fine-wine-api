import numpy as np
import json
import pandas as pd
from sklearn.neighbors import NearestNeighbors
from scipy.sparse import csr_matrix
import sys
import psycopg2  # PostgreSQL library
import itertools

conn = psycopg2.connect(
    dbname="fine_wine",
    user="adam",
    password="postgres",
    host="localhost",
    port="5432"
)

query = """
    SELECT *
    FROM wines
"""

argumentListSplited = [list(y) for x, y in itertools.groupby(sys.argv, lambda z: z == ';') if not x]

defaultParams = argumentListSplited[0]
countries = argumentListSplited[1] if argumentListSplited[1][0] != '' else None
wineColors = argumentListSplited[2] if argumentListSplited[2][0] != '' else None

wines = pd.read_sql_query(query, conn)
conn.close()

wine = wines.copy()

col = ['id','description','province','variety','points','country','wine_color','winery','price','wine_name','region_1']
wine1 = wine[col]
wine1 = wine1.dropna(axis=0)
wine1 = wine1.drop_duplicates(['province','variety'])

if countries:
    wine1 = wine1[wine1['country'].isin(countries)]
if wineColors:
    wine1 = wine1[wine1['wine_color'].isin(wineColors)]

wine_pivot = wine1.pivot(index= 'variety', columns='province', values='points').fillna(0)
wine_pivot_matrix = csr_matrix(wine_pivot)
knn = NearestNeighbors(n_neighbors=10, algorithm= 'brute', metric= 'cosine')
model_knn = knn.fit(wine_pivot_matrix)

query_index = np.random.choice(wine_pivot.shape[0])
distance, indice = model_knn.kneighbors(wine_pivot.iloc[query_index,:].values.reshape(1,-1), n_neighbors=6)

results = []
for i in range(0, len(distance.flatten())):
    variety_index = wine_pivot.index[indice.flatten()[i]]
    wine_info = wine1[wine1['variety'] == variety_index].iloc[0]
    result_item = {
        'id': float(wine_info['id']),
        'variety': wine_info['variety'],
        'wineColor': wine_info['wine_color'],
        'description': wine_info['description'],
        'price': float(wine_info['price']),
        'points': float(wine_info['points']),
        'country': wine_info['country'],
        'winery': wine_info['winery'],
        'province': wine_info['province'],
        'wineName': wine_info['wine_name'],
        'region1': wine_info['region_1'],
        'distance': float(distance.flatten()[i])
    }
    results.append(result_item)

for result_item in results:
    print(json.dumps(result_item))