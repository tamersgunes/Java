package com.hackerrank.web.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

@Service
public class BinaryNumbersServiceImpl {

    private List<Integer> binary;

    public int getMaximumNumberOfConsecutive(int n) {

        binary = new ArrayList<>();
        convertToBinary(n);

        int counter = 0;

        Iterator<Integer> iterator = binary.iterator();

        List<Integer> counterList = new ArrayList<>();

        while (iterator.hasNext()) {

            if (iterator.next() == 1) {
                counter++;
                counterList.add(counter);
            } else {
                counterList.add(counter);
                counter = 0;
            }
        }
        Collections.sort(counterList);
        return counterList.get(counterList.size() - 1);
    }

    int convertToBinary(int n) {

        if (n == 1) {
            binary.add(1);
            return 1;
        } else {
            binary.add(n % 2);
            return convertToBinary(n / 2);
        }

    }

}
