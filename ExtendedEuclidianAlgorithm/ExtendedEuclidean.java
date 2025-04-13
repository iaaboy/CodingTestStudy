package ExtendedEuclidianAlgorithm;

public class ExtendedEuclidean {
    // 결과를 담는 클래스
    static class Result {
        long gcd, x, y;
        Result(long gcd, long x, long y) {
            this.gcd = gcd;
            this.x = x;
            this.y = y;
        }
    }

    // 확장 유클리드 알고리즘
    static Result extendedGCD(long a, long b) {
        if (b == 0) {
            return new Result(a, 1, 0);  // gcd(a, 0) = a, x=1, y=0
        }

        Result res = extendedGCD(b, a % b);
        long x1 = res.y;
        long y1 = res.x - (a / b) * res.y;

        return new Result(res.gcd, x1, y1);
    }

    public static void main(String[] args) {
        long a = 100;
        long b = 35;

        Result result = extendedGCD(a, b);

        System.out.printf("gcd(%d, %d) = %d\n", a, b, result.gcd);
        System.out.printf("x = %d, y = %d\n", result.x, result.y);
        // 검증: a*x + b*y = gcd
        System.out.printf("%d*%d + %d*%d = %d\n", a, result.x, b, result.y, a*result.x + b*result.y);
    }
}