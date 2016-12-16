package jian.zhi.offer;

/**
 * Created by Jokeria on 2016/12/16.
 */
public class Power {
    /**
     * 不考虑大数情况
     * 运算逻辑：
     * exp > 0, 计算exp个base相乘的结果
     * exp < 0, 计算-exp个base乘积的倒数
     * 边界情况：
     * exp == 0，返回1.0
     * base == 0 && exp > 0, 返回0.0
     * base == 0 && exp < 0，返回1.0
     * base == 0 && exp == 0，返回1.0
     * @param base
     * @param exp
     * @return
     */
    public double power(double base, int exp) {
        if(equal(base, 0.0)) {
            if(exp > 0) {
                return 0.0;
            } else if(exp < 0){
                throw new RuntimeException("Invalide value.");
            }
        }

        double res = powerWithPositiveExp(base, Math.abs(exp));
        if(exp < 0) {
            return 1.0 / res;
        } else {
            return res;
        }
    }

    /**
     * 指数非负的幂运算函数，调用者保证exp非负
     * @param base
     * @param exp
     * @return
     */
    public double powerWithPositiveExp(double base, int exp) {
        if(exp == 0) {
            return 1.0;
        }
        if(exp == 1) {
            return base;
        }
        // 计算base的exp/2次幂
        double res = powerWithPositiveExp(base, exp >> 1);
        // 对base的exp/2次幂求平方
        res *= res;
        // exp为奇数时，结果应再乘base
        if((exp & 1) != 0) {
            res *= base;
        }

        return res;
    }

    /**
     * 判断两个double类型数是否相等。
     * 根据运算精度进行判断，这里选取保留到小数点后七位
     * @param a
     * @param b
     * @return
     */
    public boolean equal(double a, double b) {
        if(Math.abs(a - b) < 0.0000001) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Power instance = new Power();
        System.out.println(instance.power(0.0, 0));
        System.out.println(instance.power(0.0, 3));
        System.out.println(instance.power(3.3, 0));
        System.out.println(instance.power(3.3, 2));
        System.out.println(instance.power(3.3, -2));
        System.out.println(instance.power(0.0, -3));
    }
}
