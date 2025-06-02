#include <iostream>
#include <vector>
#include <string>
#include <cmath>
using namespace std;

class NQueensSolver {
public:
    vector<vector<string>> solve(int n) {
        vector<vector<string>> output;
        vector<int> pos(n);
        backtrack(0, pos, output, n);
        return output;
    }

private:
    void backtrack(int r, vector<int>& pos, vector<vector<string>>& output, int n) {
        if (r == n) {
            output.push_back(drawBoard(pos, n));
            return;
        }
        for (int c = 0; c < n; ++c) {
            if (valid(r, c, pos)) {
                pos[r] = c;
                backtrack(r + 1, pos, output, n);
            }
        }
    }

    bool valid(int r, int c, const vector<int>& pos) {
        for (int i = 0; i < r; ++i) {
            if (pos[i] == c || abs(pos[i] - c) == r - i) return false;
        }
        return true;
    }

    vector<string> drawBoard(const vector<int>& pos, int n) {
        vector<string> board(n, string(n, '.'));
        for (int i = 0; i < n; ++i) {
            board[i][pos[i]] = 'Q';
        }
        return board;
    }
};

int main() {
    NQueensSolver solver;
    vector<vector<string>> result = solver.solve(4);
    for (const auto& setup : result) {
        for (const auto& row : setup) {
            cout << row << endl;
        }
        cout << endl;
    }
    return 0;
}
