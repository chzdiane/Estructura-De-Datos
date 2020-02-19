/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabajoestructurasd;

/**
 *
 * @author Dianella
 */
public class ListasSimples<T extends Comparable > {
    
    private Node<T> head;
    
    public ListasSimples(){
        this.head = null;
    }
    
    public void add(T d){
        //crear un nuevo nodo
        //actualizar la cabeza = nuevo nodo
        
        Node<T> newNode = new Node<>(d);
        newNode.setNextNode(this.head);
        this.head = newNode;
        
    }
    
    public void addOrderedMin(T d){
        /*
        Crear un nodo para el nuevo dato.
        Si la lista esta vacía, o el valor del primer elemento de la lista 
        es mayor que el nuevo, insertar el nuevo nodo en la primera posición 
        de la lista y modificar la cabecera respectivamente.
        */
        
        /* 
         Si no se cumple el caso anterior, buscar el lugar adecuado 
         para la inserción: recorrer la lista conservando el nodo actual. 
         Inicializar nodo actual con el valor de primera posición, 
         y avanzar mientras el siguiente nodo no sea nulo y el dato 
         que contiene la siguiente posición sea menor o igual que 
         el dato a insertar.
        */
        
        /*
          Con esto se señala al nodo adecuado, 
          a continuación insertar el nuevo nodo a continuación de él.
        */
        
        Node<T> newNode = new Node<>(d);
        if(isEmpty() || d.compareTo(this.head.getData()) == -1){
            newNode.setNextNode(this.head);
            this.head = newNode;
        }
        else{
            Node<T> current = this.head;
            while(current.getNextNode() != null && d.compareTo(current.getNextNode().getData()) == 1){
                current = current.getNextNode();
            }
            newNode.setNextNode(current.getNextNode());
            current.setNextNode(newNode);
        }
    }
    
    /*
        El metodo addOrderedMax ordena los elementos en la lista de mayor a menor, funciona de la 
        misma manera que el metodo anterior simplemente le cambio la comparacion == 1 para que se adreguen
        de mayor a menor
    */
    public void addOrderedMax (T d) throws Exception{
        if(exist(d)){
            throw new Exception("El dato ya existe");
        } else{
            Node<T> newNode = new Node<>(d);
            if(isEmpty() || d.compareTo(this.head.getData()) == 1){
                newNode.setNextNode(this.head);
                this.head = newNode;
            } else{
                Node<T> current = this.head;
                while(current.getNextNode() != null && d.compareTo(current.getNextNode().getData()) == -1){
                    current = current.getNextNode();
                }
                newNode.setNextNode(current.getNextNode());
                current.setNextNode(newNode);
            }
        }
    }
    
    /*
    El metodo isEmpty verifica si la lista se encuentra vacia, validando si hay algun dato en la cabeza
    */
    public boolean isEmpty(){
        return this.head == null;
    }
    
    /*
    El metodo showData muestra todos los datos de la lista recorriendo la misma
    */
    public String showData(){
        
        String data = "";
        Node<T> current = this.head;
        while(current != null){
            data += current.getData() + " ";
            current = current.getNextNode();
        }
        return data;
    }
    
    /*
    El metodo quantityData lo que hace es reccorer la lista y en un contador sumar la cantidad de nodos que 
    hay en la lista mientras la recorre
    */
    public int quantityData(){
        int data = 0;
        Node<T> current = this.head;
        while(current != null){
            data++;
            current = current.getNextNode();
        }
        return data;
    }
    
    /*
    La lista addLast primero valida si el dato a ingresar esta en la lista, sino esta empieza a recorrer
    la lista y si la lista esta vacia automaticamente se agrega el nuevo nodo, sino verifica si el 
    siguiente nodo del que estamos iterando esta en null o vacio lo agrega en esa posicion (en la siguiente del nodo actual)
    */
    
    public void addLast(T d) throws Exception {
        if(exist(d)){
            throw new Exception("El dato ya existe en la lista");
        }else{
            if(isEmpty()){
                add(d);
            } else{
                Node<T> newNode = new Node<>(d);
                Node<T> current = this.head;
                while(current.getNextNode() != null){
                    current = current.getNextNode();
                }
                current.setNextNode(newNode);
            }
        }
    }
    
    /*
    El metodo deleteLast primero verifica si la lista esta vacia, si es asi genera un error sino busca en el siguiente
    de su siguente nodo para verificar que este vacio, esto se hace para poder borrar el siguiente nodo del actual
    que seria el ultimo de los nodos, al final le asignamos null para dejarlo vacio
    */
    
    public void deleteLast(T d) throws Exception {
        if(isEmpty()){
            throw new Exception("No existen datos a borrar");
        } 
        else{
            Node<T> current = this.head;
            while(current.getNextNode().getNextNode() != null) {
                current = current.getNextNode();
            }
            current.setNextNode(null);
        }
    }
    
    /*
    El metodo majorData devuellve un dato generico que va a ser el mayor valor insertado en los datos de la lista
    esto se hace recorriendo la lista y comparando el mayor dato que inicialmente es el dato de la cabeza con cada
    uno de los datos de ella, asi si encuentra un dato mayor lo reemplaza
    */
    
    public T majorData(){
        T dataM = this.head.getData();
        Node<T> current = this.head;
        while(current != null){
            if(current.getData().compareTo(dataM) == 1){
                dataM = current.getData();
            }
            current = current.getNextNode();
        }
        return dataM;
    }
    
    /*
    El metodo minorData devuellve un dato generico que va a ser el menor valor insertado en los datos de la lista
    esto se hace recorriendo la lista y comparando el menor dato que inicialmente es el dato de la cabeza con cada
    uno de los datos de ella, asi si encuentra un dato menor lo reemplaza
    */
    public T minorData(){
        T dataM = this.head.getData();
        Node<T> current = this.head;
        while(current != null){
            if(current.getData().compareTo(dataM) == -1){
                dataM = current.getData();
            }
            current = current.getNextNode();
        }
        return dataM;
    }
    
    /*
    El metodo avgList devuelve en promedio de los datos de la lista, primero empiezo a recorrer la lista si no esta vacia
    y tomo el dato que se encuentre en la posicion de iteracion y le hago un casteo a entera para que me permita 
    realizar operaciones matematicas, sumo todos los datos de la lista y al final los divido por la cantidad de datos
    del contador
    */
    public double avgList(){
        double sum = 0, prom = 0;
        int data=0;
        Node<T> current = head;
        while(current != null){
            if(current.getData() instanceof Integer){
                sum += (Integer)current.getData();
                data++;
                current = current.getNextNode();
            }
        }
        prom = sum/data;
        return prom;
    }
    
    /*
    El metodo exist verifica por medio de un ciclo si el dato pasado por el usuario es igual a otro dato en la lista
    y los compara con el matodo compareTo que si devuelve 0 significa que son iguales y retorna verdadero
    */
    
    public boolean exist(T d){
        //Node<T> newNode = new Node<>(d);
        Node<T> current = head;
        while(current != null){
            if(current.getData().compareTo(d) == 0){
                return true;
            }
            current = current.getNextNode();
        }
        return false;
    }
    
    /*
    El metodo deleteSpecific verifica primero si la lista esta vacia, sino empieza a reccorrer la lista hasta 
    encontrar un dato igual al pasado por el usuario y al momento de encontrarlo le asigna null para que se elimine
    el dato anteriormente ingresado
    */
    
    public void deleteSpecific(T d) throws Exception{
        if(isEmpty()){
            throw new Exception("No existen datos por borrar");
        }else {
            Node<T> current = head;
            while(current != null){
                if(current.getData().compareTo(d) == 0){
                    current.setData(null);
                }
                current = current.getNextNode();
            }
        }
    }
    
    /*
    El metodo specificData primero recorre la lista y pregunta si los datos son iguales y el siguiente dato no es null
    crea un previousNode el cual almacena el siguiente nodo del actual y en ese siguiente nodo del actual agrega el
    nuevo nodo y al nuevo nodo le asigna el nodo previo si el dato es el ultimo simplemente lo agrega en el 
    siguiente nodo y al nuevo nodo lo deja null
    */
    
    public void specificData(T newData, T data){
        Node<T> newNode = new Node<>(newData);
        Node<T> current = this.head;
        while(current != null){
            if(current.getData().compareTo(data) == 0){
                if(current.getNextNode() != null){
                    Node<T> previousNode = current.getNextNode();
                    current.setNextNode(newNode);
                    newNode.setNextNode(previousNode);
                } else {
                    current.setNextNode(newNode);
                    newNode.setNextNode(null);
                }
            }
            current = current.getNextNode();
        }
    }
    
    /*
    El metodo modifyData busca el dato que sea igual al dato pasado por el usuario si es asi no cambia como nuevo dato
    */
    public void modifyData(T data, T newData){
        Node<T> current = head;
        while(current.getNextNode() != null){
            if(current.getData().compareTo(data) == 0){
                current.setData(newData);
            }
            current = current.getNextNode();
        }
        
    }
    /*
    El metodo sameSize toma del metodo quantityData el valor de la lista actual y la compara con la nueva lista que 
    se esta ingresando, asi este metodo devuelve la cantidad de nodos de los dos y compara si son iguales
    */
    
    public boolean sameSize(ListasSimples lista){
        if(quantityData() == lista.quantityData()){
            return true;
        } else{
            return false;
        }
    }
    
    /*
    El metodo sameList primero verifica si las listas tienen igual tamaño, despues de esto crea un contador el
    cual aumenta cada vez que los datos sean exactamente iguales de cada nodo, si al final la cantidad de datos
    del contador es igual ala cantidad de nodos quiere decir que las listas son iguales
    */
    public boolean sameList(ListasSimples lista){
        if(!sameSize(lista)){
            return false;
        } else{
            int contador = 0;
            Node<T> current = this.head;
            Node<T> currentCompared = lista.head;
            while(current != null && currentCompared != null){
                if(current.getData() == currentCompared.getData()){
                    contador++;
                }
                current = current.getNextNode();
                currentCompared = currentCompared.getNextNode();
            }
            if(contador == quantityData()){
                return true;
            } else { 
                return false;
            }
        }
    }
}
