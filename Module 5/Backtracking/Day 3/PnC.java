public class PnC {

    // https://course.acciojob.com/idle?question=47372dee-2349-43c2-ac5b-35dfd0c66583
    public static void permutations(int[] boxes, int ci, int ti){
        if(ci > ti){
            // print boxes and return 
            for(int j=0; j<boxes.length; j++){
                System.out.print(boxes[j]);
            }
            System.out.println();
            return;
        }
    
          for(int i=0; i<boxes.length; i++){
              if(boxes[i]==0){
                  boxes[i] = ci;
                  permutations(boxes, ci + 1, ti);
                  boxes[i] = 0;
              }
          }
      }


      // https://course.acciojob.com/idle?question=9bca1d53-98a2-44bd-92c4-8ea7e669ca36

      // cb -current box
    // tb - total boxes
    //itpsf - items placed so far
    // ts- total items
    //asf - answer so far
  public static void combinations(int cb, int tb, int itpsf, int ts, String asf){
	if(cb > tb){
		if(itpsf == ts){
			System.out.println(asf);
		}
		return;
	}

	  // going to place item in this box
	  combinations(cb+1,tb,itpsf+1,ts,asf+"i");

	  // wont place a item in this box 
	  combinations(cb+1,tb,itpsf,ts,asf+"-");
  }

  // permutations using combination method ===========================================================
  public static void permutations(int cb, int tb, boolean[] items, int itpsf, int ts, String asf){
	if(cb > tb){
		if(itpsf == ts){
			System.out.println(asf);
		}
		return;
	}

	  // i can pick any of the remaining items
		for(int i=0; i<items.length; i++){
			if(items[i]==false){ // we have not placed current item (ith item)
				items[i] = true;
				permutations(cb+1,tb,items,itpsf+1,ts,asf+(i+1));
				items[i] = false;
			}
		}
	  
	  // keep the current box empty
	permutations(cb+1,tb,items,itpsf,ts,asf+"0"); 
  }


  // combination part 2
  public static void combinations(boolean[] boxes, int ci, int ti, int lb){
	if(ci > ti){
		for(int i=0; i<boxes.length; i++){
			if(boxes[i]==true){
				System.out.print("i");
			} else {
				System.out.print("-");
			}
		}
		System.out.println();
		return;
	}

	  for(int i = lb +1; i<boxes.length; i++){
		  if(boxes[i]==false){
			  boxes[i]=true;
			  combinations(boxes,ci+1,ti,i);
			  boxes[i]=false;
		  }
	  }
  }
    public static void main(String[] args) {
        
    }
}
