var twosum = function (nums, target) {
    var ret = new Array(2);
    for (var i = 0; i < nums.length-1; i++) {
        for (var j = i+1; j < nums.length; j++) {
            if (nums[i] + nums[j] === target) {
                ret[0] = i;
                ret[1] = j;
                break;
            }
        }
    }
    return ret;
};