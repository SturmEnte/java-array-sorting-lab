import java.util.Random;

public class StartUp {

	public static void main(String[] args) {
        ArrayVisualizer visualizer = new ArrayVisualizer();
        visualizer.setVisible(true);

        // Erstellen eines Arrays mit 100 zufälligen Werten zwischen 1 und 100
        int[] sampleArray = new int[100];
        Random random = new Random();
        for (int i = 0; i < sampleArray.length; i++) {
            sampleArray[i] = random.nextInt(100) + 1; // Zufallszahlen zwischen 1 und 100
        }

        // Anzeigen des Arrays im Visualizer
        visualizer.drawIntArray(sampleArray);
   

        // Beispielaufrufe der Sortiermethoden (auskommentiert)
        // bubbleSort(sampleArray, visualizer);
        // selectionSort(sampleArray, visualizer);
        insertionSort(sampleArray, visualizer);
        // mergeSort(sampleArray, visualizer);
        // quickSort(sampleArray, visualizer);
    }

    public static void bubbleSort(int[] array, ArrayVisualizer visualizer) {
    	int n = array.length;
		boolean swapped = false;
    	do {
			swapped = false;
		    for (int i = 0; i < n - 1; i = i + 1) {
		      visualizer.highlightIndex(i);
		      visualizer.highlightIndex(i + 1);
		      visualizer.drawIntArray(array);
		      delay(1);
		      if (array[i] > array[i + 1]) {
		        array = swap(array, i, i + 1);
		        swapped = true;
		      }
		    }
		    n = n - 1;
		} while (swapped);
    	visualizer.drawIntArray(array);
    }

    public static void selectionSort(int[] array, ArrayVisualizer visualizer) {
    	int highestIndex = array.length - 1;
    	int insertIndex = 0;
    	do {
    		int minPosition = insertIndex;
    		
    		for(int i = insertIndex + 1; i <= highestIndex; i++) {
    			if(array[i] < array[minPosition]) {
    				minPosition = i;
    			}
    		}
    		
    		visualizer.highlightIndex(minPosition);
    		visualizer.highlightIndex(insertIndex);
    		visualizer.drawIntArray(array);
    		delay(10);
    		
    		array = swap(array, minPosition, insertIndex);
    		insertIndex++;
    		
    		visualizer.drawIntArray(array);
    		delay(10);
    		
    	} while(insertIndex < highestIndex);
    	
    	visualizer.drawIntArray(array);
    	
    }

    public static void insertionSort(int[] array, ArrayVisualizer visualizer) {
        
    	for(int i = 1; i < array.length; i++) {
    		int sortValue = array[i];
    		int j = i;
    		
    		while (j > 0 && array[j - 1] > sortValue) {
    			array[j] = array[j - 1];
    			j = j - 1;
    			
    			visualizer.highlightIndex(i);
    			visualizer.highlightIndex(j);
    			visualizer.drawIntArray(array);
    			delay(10);
    		}
    		
    		array[j] = sortValue;
    		
    	}
    	
    	visualizer.drawIntArray(array);
    	
    }

    public static void mergeSort(int[] array, ArrayVisualizer visualizer) {
        // Implementierung des Merge-Sort-Algorithmus
    }

    public static void quickSort(int[] array, ArrayVisualizer visualizer) {
        // Implementierung des Quick-Sort-Algorithmus
    }

    // Weitere Sortieralgorithmen können hier hinzugefügt werden
    
    private static void delay(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Thread wurde unterbrochen");
        }
    }
    
    private static int[] swap(int[] array, int a, int b) {
    	int buffer = array[a];
    	array[a] = array[b];
    	array[b] = buffer;
    	return array;
    }

}
