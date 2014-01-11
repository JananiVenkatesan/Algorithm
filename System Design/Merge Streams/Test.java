import java.util.*;
import java.io.*;

interface MergeInputProvider{
	abstract String viewFront();
	abstract void advanceToNext();
	abstract boolean done();
}

interface MergeOutputProvider{
	abstract void emit(String data);
}

class InputProvider implements MergeInputProvider{
	private BufferedReader br;
	private String word;

	public InputProvider(BufferedReader b){
		br = b;
		try{
			word = br.readLine();
		}
		catch(Exception e){}
	}

	public String viewFront(){
		return word;
	}

	public void advanceToNext(){
		try{
			word = br.readLine();
		}
		catch(Exception e){}
	}

	public boolean done(){
		if(word == null){
			try{
				br.close();
			}
			catch(Exception e){}
			return true;
		}
		else{
			return false;
		}
	}
}

class OutputProvider implements MergeOutputProvider{
	private BufferedWriter bw;

	public OutputProvider(BufferedWriter b){
		bw = b;
	}

	public void emit(String data){
		try{
			bw.write(data);
			bw.newLine();
		}
		catch(Exception e){}
	}

	public void close(){
		try{
			bw.close();
		}
		catch(Exception e){}
	}
}

class MergeStreams{
	public int merge(ArrayList<InputProvider> inputs, OutputProvider output, Comparator c){
		int size = 0;
		PriorityQueue<InputProvider> pq = new PriorityQueue<InputProvider>(inputs.size(), c);

		for(InputProvider input : inputs){
			if(!input.done()){
				pq.add(input);
			}
		}

		while(!pq.isEmpty()){
			InputProvider input = pq.poll();
			output.emit(input.viewFront());
			size ++;
			input.advanceToNext();
			if(!input.done())
				pq.add(input);
		}

		return size;
	}
}

class InputProviderComparator implements Comparator<InputProvider>{
	public int compare(InputProvider i1, InputProvider i2){
		return i1.viewFront().compareTo(i2.viewFront());
	}
}

public class Test{
	public static void main(String[] args){
		MergeStreams ms = new MergeStreams();

		ArrayList<InputProvider> inputs = new ArrayList<InputProvider>();

		InputProvider[] ip = null;
		OutputProvider output = null;

		InputProviderComparator ipc = new InputProviderComparator();

		try{
			ip = new InputProvider[4];
			for(int i = 0; i < 4; i ++){
				ip[i] = new InputProvider(new BufferedReader(new FileReader(i + ".txt")));
				inputs.add(ip[i]);
			}

			output = new OutputProvider(new BufferedWriter(new FileWriter("demo.txt")));

			ms.merge(inputs, output, ipc);
		}	
		catch(Exception e){}
		finally{
			output.close();
		}
	}
}

/*
import java.util.*;
import java.io.*;

public class Test2{
	public static void main(String[] args){
		//ArrayList<BufferedReader> input = new ArrayList<BufferedReader>();
		BufferedReader[] br = null;
		BufferedWriter bw = null;
		try{
			// Input
			br = new BufferedReader[4];
			for(int i = 0; i < 4; i ++){
				br[i] = new BufferedReader(new FileReader(i + ".txt"));
			}
			// Output
			bw = new BufferedWriter(new FileWriter("demo2.txt"));

			String str = null;
			for(int i = 0; i < 4; i ++){
				while( (str = br[i].readLine()) != null){
					bw.write(str);
					bw.newLine();
				}
			}
		}
		catch(Exception e){}
		finally{
			for(int i = 0; i < 4; i ++){
				try{
					br[i].close();
				}
				catch(Exception e){}
			}

			try{
				bw.close();
			}
			catch(Exception e){}
		}
	}
}
*/