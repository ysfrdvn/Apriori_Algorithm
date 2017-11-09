
public class Transaction {
islemler ilk=null,son=null;
	
	public void elemanEkle(String trans,String item){
		islemler k = new islemler(trans,item);
		if(ilk == null){
			ilk = k;
			son = k;
			k.next = null;
			}
		else {
			islemler tutucu = ilk;
			while (tutucu.next != null){
				tutucu = tutucu.next;
			}
			tutucu.next = k;
			k.next= null;
			son = k;
			
		}
	}
	
	public void Listele(){
		islemler gezici = ilk;
		while(gezici != null){
			System.out.println(gezici.trans +" "+gezici.items);
			gezici = gezici.next;
		}
	}
}

class islemler{
	String trans;
	String items;
	islemler next;
	public islemler(){
		
	}
	public islemler(String trans,String items){
		this.items= items;
		this.trans = trans;
	}
	public islemler(String trans){
		this.trans = trans;
	}
	
}
