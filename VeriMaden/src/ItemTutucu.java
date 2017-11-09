
public class ItemTutucu {

	
	ItemSayisi ilk=null, son=null;
	public int KacItemVar(Transaction Deger){
		int itemSayilari=0;
		Transaction k = Deger;
		while(k.ilk != null){
			if(k.ilk.items.contains("I1"))
				if(itemSayilari<1)
					itemSayilari++;
			if(k.ilk.items.contains("I2"))
				if(itemSayilari<2)
					itemSayilari++;
			if(k.ilk.items.contains("I3"))
				if(itemSayilari<3)
					itemSayilari++;
			if(k.ilk.items.contains("I4"))
				if(itemSayilari<4)
					itemSayilari++;
			if(k.ilk.items.contains("I5"))
				if(itemSayilari<5)
					itemSayilari++;
			if(k.ilk.items.contains("I6"))
				if(itemSayilari<6)
					itemSayilari++;
			if(k.ilk.items.contains("I7"))
				if(itemSayilari<7)
					itemSayilari++;
			if(k.ilk.items.contains("I8"))
				if(itemSayilari<8)
					itemSayilari++;
			
			
			k.ilk = k.ilk.next;
			
		}
		return itemSayilari;
	}
	public void elemanEkle(){
		ItemSayisi k = new ItemSayisi();
		if(ilk == null){
			ilk = k;
			son = k;
			k.next = null;
			}
		else {
			ItemSayisi tutucu = ilk;
			while (tutucu.next != null){
				tutucu = tutucu.next;
			}
			tutucu.next = k;
			k.next= null;
			son = k;
	}
	}
	public void elemanEkle(int sayi){
		int i = 0;
		while(i < sayi){
			elemanEkle();
			i++;
		}
		
	}
	public void Ayir(){
		ItemSayisi a = ilk;
		while(a != null){
			if(a.ItemName != null){
				a.Itemlar = a.ItemName.split(" ");
			}
			a = a.next;
		}
	}
	public ItemTutucu UcluleriAyarla(){
		ItemSayisi a = ilk;
		ItemTutucu gezici = new ItemTutucu();

	
		while(a.next.next != null){
			int b=0;

			for(int i=0; i<3; i++){
				for(int j=0; j<3; j++){
					if(a.Itemlar[i].equals(a.next.Itemlar[j])){
						b++;
					
					}
				}
			}
			if(b == 3){
				gezici.elemanEkle();
				gezici.son.I = a.I;
				gezici.son.ItemName = a.ItemName;
			}
			a=a.next;
		}
		
		return gezici;
	}
	public void Listele(){
		ItemSayisi  gezici = ilk;
		if (gezici == null)
			System.out.println("Support degerinde Yeterli Tekrar eden item bulunamadý. degerli bir kural yok");
		else{
		while(gezici != null){
			System.out.println(gezici.ItemName + " " + gezici.I +" kere tekrar ediyor");
			gezici = gezici.next;
		}
		
		}
		}
	
	
}

class ItemSayisi{
	int I =0 ;
	String ItemName;
	ItemSayisi next;
	String[] Itemlar;
	
		
	public ItemSayisi(){
		
	}
	public ItemSayisi(int I){
		this.I = I;
	}
	
}