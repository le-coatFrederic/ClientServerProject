# Client Server Project - Heptathlon

#### Qu'est-ce que vous appelez gestion d'un stock ?

pouvoir ajouter du stock, ajouter de nouveaux articles dans le catalogue

pas de création de nouvel article (simplification)

modification du stock

Si 0 pas achetable

magasin

pas d'échange entre magasin

#### Qui peut gérer le stock ?

a nous de voir

peut etre deux types user (hote de caisse et responsable de rayon)

#### Comment peut-il le gérer ?

voir énoncer (peut etre interface)

#### Comment ajouter du stock ?

#### Commande ?

le client qui achète des articles

devient une facture quand valider

on paie tout de suite donc pas de liste de commandes 

#### Qu'est-ce que la suppression de stock ?

il n'y en a pas 

#### Comment supprimer du stock ?

//

#### Comment modifier du stock ?

modifier la quantité d'un article

#### Qu'est-ce qu'une facture ?

ticket de caisse 

à sauvegarder dans un fichier 

#### Qui créer la facture ?

pas toucher

fait par le système en fonction de la commande

#### Comment est-elle enregistrée ?

sous forme de fichier

#### Où est-elle enregistrée ?
 
dans le magasin

#### Combien de temps est-elle enregistrée ?

à jamais

#### Peut-on la modifier ?

non

#### Qu'est-ce qu'une vente ?

commande

#### Qui peut créer une vente ?

soit par un client (caisse automatique) soit par un hote de caisse

#### Comment est-elle créée ?

automatiquement à la caisse puis on lui ajoute des articles

#### Est-ce qu'on peut la modifier ?

oui tant que pas payée

#### Est-ce qu'on peut la supprimer ?

pas d'historique
remise en stock des articles
quand on met un article dans une commande on doit le retirer du stock

#### Qu'est-ce qu'un client ?

#### Est-ce qu'il peut accéder au système informatique ?

#### Qu'est-ce qu'un article ?

se basé sur le modèle pas sur l'entité

#### Qui peut le créer / modifier / supprimer ?

pas d'ajout de nouveaux articles sur l'interface
faire en dur dans la base de données

on peut imaginer des conditions d'affichages par exemple si sotck = 0 alors ne pas afficher

#### Qu'est-ce qu'une référence ?

on décide

#### Qui peut le créer / modifier / supprimer ?

unique dans la base données

#### Qu'est-ce qu'une famille d'article ?

soit un arbre de famille et sous famille
soit tag

#### Comment les créer ?

pas dans interface

#### Comment traite-t-on la TVA dans le système ?

valeur globale arbitraire

#### Qu'est-ce qu'un poste client ?

caisse 

deux possibilité :
    -> côté caisse
    -> côté stock

#### Où sont-ils ?

caisse
sur le magasin central pas de modification
