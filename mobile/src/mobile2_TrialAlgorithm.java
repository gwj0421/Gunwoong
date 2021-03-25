import java.io.*;

public class mobile2_TrialAlgorithm {
	static final int SIZE=26;
	static int count=0;
	public static void main(String []args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String line;
		while((line=br.readLine())!=null) {
			Trie trie=new Trie();
			int n=Integer.parseInt(line);
			String []s=new String[n];
			for(int i=0;i<n;i++) {
				s[i]=br.readLine();
				trie.insert(s[i]);
			}
			
			for(int i=0;i<SIZE;i++) {
				if(trie.root.child[i]!=null) {
					trie.check(trie.root.child[i], 1);
				}
			}
			System.out.printf("%d.2f",(double)count/n);
			System.out.println();
			count=0;
		}
		
	}
}

class Trie{
	TrieNode root=new TrieNode();
	void insert(String data) {
		char []a=data.toCharArray();
		TrieNode currentNode=root;
		for(int i=0;i<data.length();i++) {
			if(currentNode.child[(int)a[i]-'a']==null) {
				currentNode.child[(int)a[i]-'a']=new TrieNode();
				currentNode.child[(int)a[i]-'a'].childnum++;
			}
			currentNode=currentNode.child[i];
		}
		currentNode.terminal=true;
	}
	
	void check(TrieNode tr,int temp) {
		if(tr.terminal)temp++;
		if(tr.childnum>=2)temp++;
		if(tr.childnum==1&&tr.terminal)temp++;
		
		for(int i=0;i<mobile2_TrialAlgorithm.SIZE;i++) {
			if(tr.child[i]!=null)
				check(tr.child[i],temp);
		}
	}
}

class TrieNode{	//노드구조 초기화
	TrieNode []child=new TrieNode[mobile2_TrialAlgorithm.SIZE];
	boolean terminal;
	int childnum=0;
	TrieNode() {
		terminal=false;
		for(int i=0;i<mobile2_TrialAlgorithm.SIZE;i++) {
			child[i]=null;
		}
	}
}