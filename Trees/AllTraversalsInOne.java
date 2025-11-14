class Pair<U, V> {
    public U first;
    public V second;

    public Pair(U first, V second) {
        this.first = first;
        this.second = second;
    }
}




void PreInPostTraversal(TreeNode root){
    if(root==null)return;
    List<Integer>pre=new ArrayList<>();
    List<Integer>in=new ArrayList<>();
    List<Integer>post=new ArrayList<>();

    Stack<Pair>st=new Stack<>();
    st.push(new Pair(root,1));
    while(!st.isEmpty()){
        Pair it=st.pop();
        if(it.second==1){
            pre.add(it.first);
            it.second++;
            if(it.left!=null)st.push(it.left,it.second);
        }
        else if(it.second==2){
            in.add(it.first);
            it.second++;
            if(it.right!=null)st.push(it.right,it.second);
        }
        else{
            post.add(it.first);
        }
    }
}