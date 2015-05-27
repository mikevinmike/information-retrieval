# information-retrieval

based on http://users.dsic.upv.es/~pgupta/terrier_tut/
- if an error occurs check if terrier-3.5/var/index/tut is removed

check class InformationRetrieval, and the execution of printPostingsOfInvertedIndex() which should contain all relevant data for assignment 1

configuration
------------
important files
- terrier-3.5/etc/terrier.properties
- terrier-3.5/etc/collection.spec

assignment 1
------------
Verwendung des positional index wie in der VO
beschrieben:
◦ Dictionary file: eine sortierte Liste des Vokabulars (in
getrennten Zeilen)
◦ Postings list: für jeden Token eine Liste der Vorkommen im
originalen Text
 termi, dfi: <doc1, tfi1: <pos1, pos2, ... >; doc2, tfi2: <pos1,
pos2, ...>; ...>
 dfi: document frequency of termi
 tfij: term frequency of termi in docj
 to, 993427:
<1, 6: <7, 18, 33, 72, 86, 231>;
2, 5: <1, 17, 74, 222, 255>; ... >
 ...
