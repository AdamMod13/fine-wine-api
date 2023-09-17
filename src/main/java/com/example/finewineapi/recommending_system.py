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

country = sys.argv[1]
color = sys.argv[2]

col = ['province','variety','points']
wine1 = wine[col]
wine1 = wine1.dropna(axis=0)
wine1 = wine1.drop_duplicates(['province','variety'])
wine1 = wine1[wine1['points'] > 85]

wine_pivot = wine1.pivot(index= 'variety', columns='province', values='points').fillna(0)
wine_pivot_matrix = csr_matrix(wine_pivot)
knn = NearestNeighbors(n_neighbors=10, algorithm= 'brute', metric= 'cosine')
model_knn = knn.fit(wine_pivot_matrix)

query_index = np.random.choice(wine_pivot.shape[0])
distance, indice = model_knn.kneighbors(wine_pivot.iloc[query_index,:].values.reshape(1,-1), n_neighbors=6)
for i in range(0, len(distance.flatten())):
    print('{0}: {1} with distance: {2}'.format(i,wine_pivot.index[indice.flatten()[i]],distance.flatten()[i]))
