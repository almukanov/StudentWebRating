package ru.almukanov.service;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.almukanov.dao.StudentDao;

import java.text.DecimalFormat;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceTest {
StudentService studentService = new StudentsServiceImpl();
    @Test
    void calculatingRate() {
        int[] answerActivity = new int[]{3,5,7,1,2,9,3,1,0,4};
        int[] selfActivity = new int[]  {2,1,4,50,4,0,2,3,5,4};
        int[] questionfActivity = new int[]{6,1,7,1,5,9,3,10,0,4};
        for (int i = 0; i < 10; i++) {
            assertEquals(studentService.calculatingRate(answerActivity[i],selfActivity[i],questionfActivity[i]),
                    Double.parseDouble(new DecimalFormat("#0.00").format((double)(answerActivity[i]+selfActivity[i]*2+questionfActivity[i]*2)/3).replace(",",".")));

        }

    }
}