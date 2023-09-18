import numpy as np
from sklearn.neighbors import KNeighborsClassifier
import pandas as pd
from sklearn.neighbors import NearestNeighbors
from scipy.sparse import csr_matrix
from sklearn.decomposition import TruncatedSVD
import requests
from bs4 import BeautifulSoup
import sys

wines = pd.read_csv('src/main/java/com/example/finewineapi/fine-wine-data.csv', sep=';', index_col=0)
wine = wines.copy()

country = sys.argv[1] if sys.argv[1] != "-" else None
color = sys.argv[2] if sys.argv[2] != "-" else None
variety = sys.argv[3] if sys.argv[3] != "-" else None
winery = sys.argv[4] if sys.argv[4] != "-" else None
minPoints = int(sys.argv[5]) if sys.argv[5] != "-" else None
maxPrice = int(sys.argv[6]) if sys.argv[6] != "-" else None

col = ['province','variety','points']
wine1 = wine[col]
wine1 = wine1.dropna(axis=0)
wine1 = wine1.drop_duplicates(['province','variety'])
if country:
    wine1 = wine1[wine1['country'] == country]
if color:
    wine1 = wine1[wine1['color'] == color]
if variety:
    wine1 = wine1[wine1['variety'] == variety]
if winery:
    wine1 = wine1[wine1['winery'] == winery]
if minPoints:
    wine1 = wine1[wine1['points'] > minPoints]
else:
    wine1 = wine1[wine1['points'] > 85]
if maxPrice:
    wine1 = wine1[wine1['price'] < maxPrice]

wine_pivot = wine1.pivot(index= 'variety', columns='province', values='points').fillna(0)
wine_pivot_matrix = csr_matrix(wine_pivot)
knn = NearestNeighbors(n_neighbors=10, algorithm= 'brute', metric= 'cosine')
model_knn = knn.fit(wine_pivot_matrix)

query_index = np.random.choice(wine_pivot.shape[0])
distance, indice = model_knn.kneighbors(wine_pivot.iloc[query_index,:].values.reshape(1,-1), n_neighbors=6)
for i in range(0, len(distance.flatten())):
    print('{0}: {1} with distance: {2}'.format(i,wine_pivot.index[indice.flatten()[i]],distance.flatten()[i]))
