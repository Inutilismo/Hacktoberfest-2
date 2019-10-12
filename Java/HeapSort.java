// Implementação do algoritmo HeapSort em Java
public class HeapSort 
{ 
    public void sort(int arr[]) 
    { 
        int n = arr.length; 
  
        // Construa o heap (reorganize o vetor) 
        for (int i = n / 2 - 1; i >= 0; i--) 
            heapify(arr, n, i); 
  
        // Extraia elementos do heap um por um 
        for (int i=n-1; i>=0; i--) 
        { 
            // Mova a raiz atual para o fim
            int temp = arr[0]; 
            arr[0] = arr[i]; 
            arr[i] = temp; 
  
            // chame max heapify pra reduzir o heap
            heapify(arr, i, 0); 
        } 
    } 
  
    void heapify(int arr[], int n, int i) 
    { 
        int largest = i;  // Inicializa largest como a raiz
        int l = 2*i + 1;  // esquerda = 2*i + 1 
        int r = 2*i + 2;  // direita = 2*i + 2 
  
        // Se o filho da esquerda é maior que a raiz 
        if (l < n && arr[l] > arr[largest]) 
            largest = l; 
  
        // Se o filho da direita é maior que largest
        if (r < n && arr[r] > arr[largest]) 
            largest = r; 
  
        // Se largest não é uma raiz 
        if (largest != i) 
        { 
            int swap = arr[i]; 
            arr[i] = arr[largest]; 
            arr[largest] = swap; 
  
            // Use da recursão para aplicar o heapify na sub-árvore
            heapify(arr, n, largest); 
        } 
    } 
  
    /* Função para imprimir um array de tamanho n */
    static void printArray(int arr[]) 
    { 
        int n = arr.length; 
        for (int i=0; i<n; ++i) 
            System.out.print(arr[i]+" "); 
        System.out.println(); 
    } 
  
    // Teste 
    public static void main(String args[]) 
    { 
        int arr[] = {12, 11, 13, 5, 6, 7}; 
        int n = arr.length; 
  
        HeapSort ob = new HeapSort(); 
        ob.sort(arr); 
  
        System.out.println("Sorted array is"); 
        printArray(arr); 
    } 
} 
