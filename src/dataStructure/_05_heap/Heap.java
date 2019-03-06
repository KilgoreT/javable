package dataStructure._05_heap;

/**
 * Пирамида (Heap)
 * Это двоичное дерево со свойствами:
 *  1. Полнота: все уровни заполнены, последний заполнен частично(по порядку, начиная с левого).
 *  2. Обычно реализуется на базе массива. Если реализовывать на базе дерева возникает проблема:
 *      поиск последнего узла и поиск первого пустого узла(хотя можно сохранять путь как в дереве Хаффмана)
 *  3. для каждого узла выполняется условие, ключ узла >= ключей его потомков.
 *
 *  Пирамида - слабоупорядоченная.
 *  Перебор затруднен.
 *  Удаление узла с заданым ключем невозможно найти за O(logN), только за O(N).
 *
 *  Операции:
 *   1. удаление наибольшего узла.
 *   2. вставка новых узлов.
 *
 *   Представление дерева в виде массива:
 *   1. индекс родителя = (x - 1)/2;
 *   2. индекс левого потомка = 2 * x + 1;
 *   3. индекс правого потомка = 2 * x + 2;
 */
public class Heap {

    private Node[] heapArray;
    private int maxSize;
    private int currentSize;

    public Heap(int maxSize) {
        this.maxSize = maxSize;
        this.currentSize = 0;
        this.heapArray = new Node[maxSize];
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public boolean insert(int key) {
        if (currentSize == maxSize) return false;
        Node node = new Node(key);
        heapArray[currentSize] = node;
        trickleUp(currentSize++);
        return true;
    }

    public Node remove() {
        Node root = heapArray[0];
        heapArray[0] = heapArray[--currentSize];
        trickleDown(0);
        return root;
    }
    // отдельная сложность с поиском элемента
    // либо передавать индекс в метод, либо искать с эффективностью O(N)
    public boolean change(int index, int newValue) {
        if (index < 0 || index >= currentSize) {
            return false;
        }
        int oldValue = heapArray[index].getKey();
        heapArray[index].setKey(newValue);

        if (oldValue > newValue) {
            trickleDown(index);
        } else {
            trickleUp(index);
        }
        return true;
    }

    private void trickleDown(int index) {
        int largerChild;
        // сохраним перемещаемый узел
        Node top = heapArray[index];

        // пока у узла есть потомок
        while (index < currentSize / 2) {
            // находим левого потомка
            int leftChild = 2 * index + 1;
            // находим правого потомка (его может не существовать!!!)
            int rightChild = leftChild + 1;
            // если правый существует и его ключ больше левого
            if (rightChild < currentSize && heapArray[leftChild].getKey() < heapArray[rightChild].getKey()) {
                // то больший - правый
                largerChild = rightChild;
            } else {
                // или левый
                largerChild = leftChild;
            }
            // проверяем, что перемещаемый вниз узел с меньшим ключом, чем больший потомок
            if (top.getKey() >= heapArray[largerChild].getKey()) {
                break;
            }
            // большего потомка поднимаем вверх
            heapArray[index] = heapArray[largerChild];
            // а индекс опускаем уровнем ниже.
            index = largerChild;
        }
        // нашли индекс - вставили заранее сохраненный top
        heapArray[index] = top;
    }

    private void trickleUp(int index) {
        // получаем родителя
        int parent = (index - 1) / 2;
        // сохраним перемещаемый элемент
        Node bottom = heapArray[index];

        // пока узел не дошел до самого верха или того момента, когда ключ потомка больше него
        while (index > 0 && heapArray[parent].getKey() < bottom.getKey()) {
            // опускаем родителя ниже
            heapArray[index] = heapArray[parent];
            // поднимаем индекс на уровень выше
            index = parent;
            // высчитываем нового родителя
            parent = (parent - 1) / 2;
        }
        // так как найден такой индекс, который меньше родителя и больше потомка - вставляем туда сохраненный bottom
        heapArray[index] = bottom;
    }
}
