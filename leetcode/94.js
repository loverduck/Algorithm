var inorderTraversal = function(root) {
    const result = [];
    
    const inorder = (node) => {
        if (node === null) return;
        inorder(node.left);
        result.push(node.val);
        inorder(node.right);
    }
    inorder(root);
    return result;
};