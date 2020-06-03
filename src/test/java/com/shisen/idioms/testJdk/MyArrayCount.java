package com.shisen.idioms.testJdk;

/**
 * <pre>
 * Description
 * @author shishi
 * 2020/5/28 16:37
 * </pre>
 */
public class MyArrayCount extends MyArray {
    private int count = 0;

    @Override
    public void add(Object element) {
        super.add(element);
        count++;
    }

    @Override
    public void addAll(Object[] elements) {
        super.addAll(elements);
        count += elements.length;
    }

    public int getCount() {
        return count;
    }
}
