package com.shisen.idioms.testJdk;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * <pre>
 * Description
 * @author shishi
 * 2020/10/21 17:52
 * </pre>
 */
public class MyTest {

    public <T, R> Optional<R> getList(T lists, Predicate<T> predicate, Function<T, R> function) {
        Objects.requireNonNull(predicate);
        R result = null;

        if (predicate.test(lists)) {
            result = function.apply(lists);
        }
        return Optional.ofNullable(result);
    }

    public static void main(String[] args) {
        MyTest myTest = new MyTest();

        List<Long> list = new ArrayList<>();
        list.add(1L);
        list.add(2L);
        OrderMapper orderMapper = new OrderMapper();

        List<ContractDto> list1 = myTest.getList(list, CollectionUtils::isNotEmpty, orderMapper::getCurLocationByPlateNo)
                .orElseGet(ArrayList::new);


        System.out.println("list1 = " + list1);

    }

}

@Data
class ContractDto {
    private long id;
}

class CollectionUtils {
    public static boolean isNotEmpty(List list) {
        return null != list && list.size() > 0;
    }
}

class OrderMapper {
    List<ContractDto> getDischargeFinishTimeByPlanId(List<Long> list) {

        ArrayList<ContractDto> contractDtos = new ArrayList<>();
        for (Long aLong : list) {
            ContractDto contractDto = new ContractDto();
            contractDto.setId(aLong);
            contractDtos.add(contractDto);
        }

        return contractDtos;
    }

    List<ContractDto> getCurLocationByPlateNo(List<Long> list) {
        ArrayList<ContractDto> contractDtos = new ArrayList<>();
        for (Long aLong : list) {
            ContractDto contractDto = new ContractDto();
            contractDto.setId(aLong + 1);
            contractDtos.add(contractDto);
        }

        return contractDtos;
    }
}