- 递归代码模板
``` java
public void recur(int level, int param) {
    //return condition
    if (level > max) {
        return;
    }
    
    // process
    process(level, param);
    
    //drill down
    recur(level + 1, newParam);
    
    // reset current status
}
```

- 分治代码模板

``` python
def divide(Problem problem, param1...) {
    if (problem == null) {
        sout(result);
        return;
    }
    
    //prepare data
    data = prepare_data(problem);
    subproblem = split_problem(proble, data);
    
    // conquer subProblem
    subResult1 = divide(subProblem[0], p1,...);
    subResult2 = divide(subProblem[1], p1,...);
    subResult3 = divide(subProblem[2], p1,...);
    
    // process and generate the final result
    result = process_result(subresult1, subresult2,...);
    
    // revert the current status
    
}
```
