# Hidden Blocks — Fabric 26.3

Ce projet ajoute des objets correspondant à des blocs techniques vanilla qui n'ont pas d'objet vanilla normal dans l'onglet **Utilitaires d'opérateur**. Il ne crée aucun nouvel onglet créatif.

Les blocs opérateur qui sont déjà fournis par Minecraft (barrière, générateur de monstres, bloc de lumière, blocs de commande, bloc de structure, jigsaw, etc.) restent dans leur emplacement vanilla : le mod ne les duplique pas.

## Compilation avec GitHub Actions

1. Crée un dépôt GitHub et envoie-y tous les fichiers de ce projet.
2. Ouvre l'onglet **Actions** du dépôt.
3. Lance **Build Fabric mod** avec **Run workflow** (ou pousse un commit sur `main`).
4. À la fin, ouvre l'exécution terminée et télécharge l'artefact `hiddenblocks-fabric-26.3`.
5. Place le `.jar` compilé dans le dossier `mods` avec Fabric Loader et Fabric API compatibles avec Minecraft 26.3.

## Environnement ciblé

- Minecraft Java 26.3
- Fabric Loader 0.20.1
- Fabric API 0.162.0+26.3
- Fabric Loom 1.19-SNAPSHOT
- Gradle 9.6.0
- Java 25

## Limites des blocs techniques

Le mod fournit des icônes d'inventaire pour les blocs de portail, de feu et les parties de piston. Leur présence dans l'onglet ne garantit pas qu'ils puissent être posés librement : Minecraft impose des règles spéciales à ces blocs (portails générés par le jeu, feu soumis à ses conditions, piston-head/moving-piston liés au fonctionnement des pistons).

La liste est centralisée dans `HiddenBlocksMod.java`, dans `BLOCKS_WITHOUT_VANILLA_ITEMS`.
