package com.coevolution;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


class TreeNode {
    double val;
    CandidateSolution candidateSolution;
    TreeNode left;
    TreeNode right;

    public TreeNode(double val, CandidateSolution candidateSolution) {
        this.val = val;
        this.candidateSolution = candidateSolution;
        left = null;
        right = null;
    }

    private int size(TreeNode node) {
        if (node == null)
            return (0);
        else {
            return (size(node.left) + 1 + size(node.right));
        }
    }

    public TreeNode getRandomNode() {
        int r = new Random().nextInt(size(this));
        if (r == 0) {
            return this;
        } else if (left != null && 1 <= r && r <= size(left)) {
            return left.getRandomNode();
        } else {
            return right.getRandomNode();
        }
    }
}

public class BinarySearchTree {
    private Random random;
    private TreeNode root;

    public BinarySearchTree() {
        this.random = new Random();
        root = null;
    }

    public BinarySearchTree(TreeNode root) {
        this.root = root;
    }

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public BinarySearchTree getTree(TreeNode root) {
        BinarySearchTree treeNodes = new BinarySearchTree();
        inorderTraversal(root, treeNodes);
        return treeNodes;
    }

    private void inorderTraversal(TreeNode node, BinarySearchTree tree) {
        if (node != null) {
            inorderTraversal(node.left, tree);
            tree.insert(node);
            inorderTraversal(node.right, tree);
        }
    }

    public void setUnassignedSolutions(TreeNode node) {
        inOrderTraversalsetUnassigned(node);
    }

    private void inOrderTraversalsetUnassigned(TreeNode node) {
        if (node != null) {
            inOrderTraversalsetUnassigned(node.left);
            node.candidateSolution.setIsAssigned(false);
            inOrderTraversalsetUnassigned(node.right);
        }
    }

    public List<TreeNode> getUnassignedSolutions() {
        List<TreeNode> unassignedSolutions = new ArrayList<>();
        inOrderTraversalGetUnassigned(root, unassignedSolutions);
        return unassignedSolutions;
    }

    private void inOrderTraversalGetUnassigned(TreeNode node, List<TreeNode> unassignedSolutions) {
        if (node != null) {
            inOrderTraversalGetUnassigned(node.left, unassignedSolutions);
            if (!node.candidateSolution.getIsAssigned()) {
                unassignedSolutions.add(node);
            }
            inOrderTraversalGetUnassigned(node.right, unassignedSolutions);
        }
    }

    public TreeNode getNode(TreeNode node) {
        return search(node, root);
    }

    private TreeNode search(TreeNode node, TreeNode root) {
        if (node != null) {
            if (root.candidateSolution.equals(root.candidateSolution)) {
                return node;
            } else {
                TreeNode foundNode = search(node, root.left);
                if (foundNode == null) {
                    foundNode = search(node, root.right);
                }
                return foundNode;
            }
        } else {
            return null;
        }
    }

    public TreeNode findMinNormValue() {
        if (root == null) {
            return null; // or throw an exception
        }
        return findMinNormValueRec(root);
    }

    private TreeNode findMinNormValueRec(TreeNode root) {
        TreeNode minNode = root;
        if (root.left != null) {
            TreeNode leftMin = findMinNormValueRec(root.left);
            if (leftMin.val < minNode.val) {
                minNode = leftMin;
            }
        }
        if (root.right != null) {
            TreeNode rightMin = findMinNormValueRec(root.right);
            if (rightMin.val < minNode.val) {
                minNode = rightMin;
            }
        }
        return minNode;
    }

    public void traverseFitness(TreeNode root) {
        traverseAndComputeFitness(root);
    }

    private void traverseAndComputeFitness(TreeNode root) {
        if (root != null) {
            root.candidateSolution.setFitnessValues();

            traverseAndComputeFitness(root.left);
            traverseAndComputeFitness(root.right);
        }
    }

    public void traverseFitnessNorm(TreeNode root) {
        traverseAndComputeFitnessNorm(root);
    }

    private void traverseAndComputeFitnessNorm(TreeNode root) {
        if (root != null) {
            root.candidateSolution.getTotalFitness();
            root.val = root.candidateSolution.getTotalFitness();

            traverseAndComputeFitnessNorm(root.left);
            traverseAndComputeFitnessNorm(root.right);
        }
    }

    public double computeTotalNormFitness(TreeNode node, Model metamodel, Model model) {
        if (node == null) {
            return 0;
        }
        return node.candidateSolution.getTotalFitness() +
                computeTotalNormFitness(node.left, metamodel, model) +
                computeTotalNormFitness(node.right, metamodel, model);
    }

    public TreeNode getSolutionFromFitness(TreeNode root, double rand, Model model) {
        return solutionFromFitnessTraverse(root, rand, model);
    }

    private TreeNode solutionFromFitnessTraverse(TreeNode root,
            double rand, Model model) {
        if (root == null) {
            return null;
        }
        double fitness = root.val;
        if (rand <= fitness) {
            return root;
        }

        rand -= fitness;

        TreeNode leftResult = solutionFromFitnessTraverse(root.left, rand, model);
        if (leftResult != null) {
            return leftResult;
        }
        return solutionFromFitnessTraverse(root.right, rand, model);
    }

    public void setInitialCrowdingDistance(TreeNode node) {
        if (node != null) {
            node.candidateSolution.setCrowdingDistance(0.0);

            setInitialCrowdingDistance(node.left);
            setInitialCrowdingDistance(node.right);
        }
    }

    public void insert(TreeNode node) {
        root = insertRec(root, node);
    }

    private TreeNode insertRec(TreeNode root, TreeNode node) {
        if (root == null) {
            root = new TreeNode(node.val, node.candidateSolution);
            return root;
        }

        if (node.val < root.val) {
            root.left = insertRec(root.left, node);
        }
        if (node.val > root.val) {
            root.right = insertRec(root.right, node);
        }
        if (node.val == root.val) {
            int rand = random.nextInt(2);
            if (rand == 0) {
                root.left = insertRec(root.left, node);
            }
            if (rand == 1) {
                root.right = insertRec(root.right, node);
            }
        }

        return root;
    }

    public void addAll(BinarySearchTree otherTree) {
        if (otherTree != null && otherTree.getRoot() != null) {
            addAll(root, otherTree.getRoot());
        }
    }

    private void addAll(TreeNode targetNode, TreeNode sourceNode) {
        if (sourceNode != null) {
            insert(sourceNode);
            addAll(targetNode, sourceNode.left);
            addAll(targetNode, sourceNode.right);
        }
    }

    public int size() {
        return (size(root));
    }

    public int sizeFromNode(TreeNode fromNode) {
        return (size(fromNode));
    }

    private int size(TreeNode node) {
        if (node == null)
            return (0);
        else {
            return (size(node.left) + 1 + size(node.right));
        }
    }

    public TreeNode getPredecessor(TreeNode node) {
        if (node == null) {
            return null;
        }

        if (node.left != null) {
            return findMax(node.left);

        }
        TreeNode parent = getParent(node);
        while (parent != null && node == parent.left) {
            node = parent;
            parent = getParent(parent);
        }

        return parent;
    }

    public TreeNode getSuccessor(TreeNode node) {
        if (node == null) {
            return null;
        }

        if (node.right != null) {
            return findMin(node.right);
        }

        TreeNode parent = getParent(node);
        while (parent != null && node == parent.right) {
            node = parent;
            parent = getParent(parent);
        }

        return parent;
    }

    public TreeNode getParent(TreeNode node) {
        if (node == null || node == root) {
            return null;
        }

        TreeNode parent = null;
        TreeNode current = root;

        while (current != null) {
            double currentVal = current.val;
            double nodeVal = node.val;

            if (nodeVal == currentVal) {
                break;
            } else if (nodeVal < currentVal) {
                parent = current;
                current = current.left;
            } else {
                parent = current;
                current = current.right;
            }
        }
        return parent;
    }

    public TreeNode findMax(TreeNode node) {
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    public TreeNode findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public List<TreeNode> inOrderTraversal() {
        List<TreeNode> nodes = new ArrayList<>();
        inOrderTraversalHelper(root, nodes);
        return nodes;
    }

    private void inOrderTraversalHelper(TreeNode root, List<TreeNode> nodes) {
        if (root != null) {
            inOrderTraversalHelper(root.left, nodes);
            nodes.add(root);
            inOrderTraversalHelper(root.right, nodes);
        }
    }
}