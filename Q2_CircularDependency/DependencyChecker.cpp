#include <iostream>
#include <vector>
using namespace std;

class DependencyChecker {
public:
    bool hasCircularDependency(int n, const vector<vector<int>>& edges) {
        vector<vector<int>> links(n);
        for (const auto& edge : edges) {
            links[edge[0]].push_back(edge[1]);
        }
        vector<int> seen(n, 0);
        for (int i = 0; i < n; ++i) {
            if (trace(i, links, seen)) return true;
        }
        return false;
    }

private:
    bool trace(int node, const vector<vector<int>>& links, vector<int>& seen) {
        if (seen[node] == 1) return true;
        if (seen[node] == 2) return false;

        seen[node] = 1;
        for (int next : links[node]) {
            if (trace(next, links, seen)) return true;
        }
        seen[node] = 2;
        return false;
    }
};

int main() {
    DependencyChecker checker;

    vector<vector<int>> graph1 = {{0, 1}, {1, 2}, {2, 3}};
    vector<vector<int>> graph2 = {{0, 1}, {1, 2}, {2, 0}};

    cout << boolalpha;
    cout << checker.hasCircularDependency(4, graph1) << endl;
    cout << checker.hasCircularDependency(4, graph2) << endl;

    return 0;
}
