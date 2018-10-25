public class ArrayList implements List {
    private Object[] arr;
    private int head;

    public ArrayList(){
        arr = new Object[10];
        head = 0;
    }

    @Override
    public void add(Object obj){
        add(head, obj);
    }

    @Override
    public void add(int pos, Object obj){
        if(head + 1 == arr.length){
            growArray();
        }
        for (int i = arr.length - 1; i > pos; i--) {
            arr[i] = arr[i - 1];
        }
        arr[pos] = obj;
        head++;
    }

    @Override
    public Object get(int pos){
        return arr[pos];
    }

    @Override
    public Object remove(int pos){
        Object curr = arr[pos];

        for(int i = pos; i < arr.length - 1; i++){
            arr[i] = arr[i + 1];
        }
        return curr;
    }

    @Override
    public int size(){
        int count = 0;
        for(int i = 0; i < arr.length; i++) {
            if (arr[i] != null) {
                count++;
            }
        }
        return count;
    }

    public void growArray(){
        Object[] newArr = new Object[arr.length * 2];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
    }
}
