import java.io.*;
import java.util.*;

// bigint
class BigInteger {
  private static final int BASE = 1000000000;
  private static final int BASE_DIGITS = 9;
  private static final int MAX_DIGITS = 1000;
  private int[] digits;
  private int size;
  public BigInteger() {
    digits = new int[MAX_DIGITS];
    size = 0;
  }
  public BigInteger(int x) {
    this();
    do {
      digits[size++] = x % BASE;
      x /= BASE;
    } while(x > 0);
  }
  public BigInteger(String s) {
    this();
    int len = s.length();
    for(int i = len - BASE_DIGITS; i > 0; i -= BASE_DIGITS) {
      digits[size++] = Integer.parseInt(s.substring(i, i + BASE_DIGITS));
    }
    digits[size++] = Integer.parseInt(s.substring(0, i));
  }
  public BigInteger add(BigInteger other) {
    BigInteger result = new BigInteger();
    int carry = 0;
    for(int i = 0; i < Math.max(size, other.size) || carry > 0; i++) {
      if(i == result.size) {
        result.digits[result.size++] = 0;
      }
      result.digits[i] += (i < size ? digits[i] : 0) + (i < other.size ? other.digits[i] : 0) + carry;
      carry = result.digits[i] >= BASE ? 1 : 0;
      if(carry > 0) {
        result.digits[i] -= BASE;
      }
    }
    return result;
  }
  public BigInteger multiply(BigInteger other) {
    BigInteger result = new BigInteger();
    for(int i = 0; i < size; i++) {
      int carry = 0;
      for(int j = 0; j < other.size || carry > 0; j++) {
        if(i + j == result.size) {
          result.digits[result.size++] = 0;
        }
        long current = result.digits[i + j] + (long) digits[i] * (j < other.size ? other.digits[j] : 0) + carry;
        result.digits[i + j] = (int) (current % BASE);
        carry = (int) (current / BASE);
      }
    }
    return result;
  }
  public String toString() {
    StringBuilder
}

public class Skeleton {
  static class FastReader {
    BufferedReader br;
    StringTokenizer st;
    public FastReader() {
      br = new BufferedReader(new InputStreamReader(System.in));
    }
    String next() {
      while(st == null || !st.hasMoreTokens()) {
        try {
          st = new StringTokenizer(br.readLine());
        } catch(IOException e) {
          e.printStackTrace();
        }
      }
      return st.nextToken();
    }
    int nextInt() {
      return Integer.parseInt(next());
    }
    long nextLong() {
      return Long.parseLong(next());
    }
    double nextDouble() {
      return Double.parseDouble(next());
    }
    String nextLine() {
      String str="";
      try {
        str = br.readLine().trim();
      } catch(Exception e) {
        e.printStackTrace();
      }
      return str;
    }
  }

  static class FastWriter {
    private final BufferedWriter bw;

    public FastWriter() {
      this.bw = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    public void print(Object object) throws IOException {
      bw.append("" + object);
    }

    public void println(Object object) throws IOException {
      print(object);
      bw.append("\n");
    }

    public void close() throws IOException {
      bw.close();
    }
  }

  public static void main(String[] args) {
    try {
      FastReader in = new FastReader();
      FastWriter out = new FastWriter();
      int testCases = in.nextInt();
      while(testCases --> 0) {
        solve(in, out);
      }
      out.close();
    } catch (Exception e) {
      return;
    }
  }

  public static void solve(FastReader in, FastWriter out) throws IOException {

  }
}

