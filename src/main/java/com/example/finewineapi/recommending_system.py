import json
import pandas as pd
from sklearn.neighbors import NearestNeighbors
from scipy.sparse import csr_matrix
import sys
import psycopg2
import itertools

conn = psycopg2.connect(
    dbname="fine_wine",
    user="adam",
    password="postgres",
    host="localhost",
    port="5432"
)
query = """
    SELECT * FROM wines 
"""

argumentListSplited = [list(y) for x, y in itertools.groupby(sys.argv, lambda z: z == ';') if not x]
defaultParams = argumentListSplited[0]
pickedWineId = argumentListSplited[3] if argumentListSplited[3][0] != '' else None

queryWine = """
    SELECT * 
    FROM wines 
    WHERE id = %(wine_id)s
"""
cur = conn.cursor()
cur.execute(queryWine, {'wine_id': pickedWineId[0]})
pickedWine = cur.fetchone()
cur.close()

wines = pd.read_sql_query(query, conn)
conn.close()

wine = wines.copy()

col = ['id','variety','winery','price','points','province','country','wine_color']
wine1 = wine[col]
wine1 = wine1.dropna(axis=0)
wine1 = wine1.drop_duplicates(['winery','variety'])
wine_pivot = wine1.pivot(index= 'winery', columns=['variety','price','wine_color'], values='points').fillna(0)
wine_pivot_matrix = csr_matrix(wine_pivot)
knn = NearestNeighbors(n_neighbors=10, algorithm= 'brute', metric= 'cosine')
model_knn = knn.fit(wine_pivot_matrix)
query_index = wine_pivot.index.get_loc(pickedWine[3])
distance, indice = model_knn.kneighbors(wine_pivot.iloc[query_index,:].values.reshape(1,-1), n_neighbors=6)

results = []
for i in range(0, len(distance.flatten())):
    variety_index = wine_pivot.index[indice.flatten()[i]]
    wine_info = wine1[wine1['winery'] == variety_index].iloc[0]
    result_item = {
        'id': float(wine_info['id']),
        'variety': wine_info['variety'],
        'points': float(wine_info['points']),
        'country': wine_info['country'],
        'winery': wine_info['winery'],
        'distance': float(distance.flatten()[i])
    }
    results.append(result_item)

for result_item in results:
    print(json.dumps(result_item))