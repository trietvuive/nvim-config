#include<bits/stdc++.h>
#define endl '\n'
using namespace std;

using ll = long long;
using graph = vector<vector<int>>;
constexpr ll MOD = 1e9 + 7;

// matrix exponentiation
vector<vector<ll>> matmul(vector<vector<ll>> &a, vector<vector<ll>> &b) {
  int n = a.size(), m = a[0].size(), k = b[0].size();
  vector<vector<ll>> c(n, vector<ll>(k, 0));
  for(int i = 0; i < n; ++i) {
    for(int j = 0; j < k; ++j) {
      for(int l = 0; l < m; ++l) {
        c[i][j] = (c[i][j] + a[i][l] * b[l][j]) % MOD;
      }
    }
  }
}

int main() {
  ios::sync_with_stdio(false); cin.tie(nullptr);
  int tc = 1;
  while(tc--) solve();
}

