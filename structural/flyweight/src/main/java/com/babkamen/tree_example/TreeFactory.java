package com.babkamen.tree_example;

import java.io.IOException;

public interface TreeFactory {

    TreeType createTree(int treeType) throws IOException;
}
