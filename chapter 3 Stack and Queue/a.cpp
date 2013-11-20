#include <iostream>
#include <map>
#include <queue>
#include <vector>
using namespace std;

class TestResult {
public:
    int studentId;
    string testDate;
    int testScore;
    TestResult(int s, int t){
        studentId = s;
        testScore = t;
    }
};
typedef priority_queue<int, std::vector<int>, std::greater<int> > my_pq; 
map<int, double>  calculateFinalScores (vector<TestResult> results) {      
    map<int, my_pq> q_map;
    for(int i = 0; i < results.size(); i ++){
        map<int, my_pq>::iterator stu_q = q_map.find(results[i].studentId);
        if(stu_q == q_map.end()){
            my_pq q;
            q.push(results[i].testScore);
            q_map.insert(
                std::pair<int, my_pq >(results[i].studentId, q) );
        } else if( (stu_q->second).size() < 5){
            stu_q->second.push(results[i].testScore) ;
        } else if( stu_q->second.top() < results[i].testScore){
            stu_q->second.pop();
            stu_q->second.push(results[i].testScore);
        }
    }
    map<int, double> retVal;
    map<int, my_pq>::iterator it;
    for(it = q_map.begin(); it!= q_map.end(); it++){
        cout << "test" << endl;
        double x = 0.0;
        for(int i = 0; i <5; i ++ ){
            x += (double)(it->second).top();
            (it->second).pop();
        }
        retVal.insert(pair<int, double>(it->first, x/5) );   
    }
    return retVal;
}
int main(){
    vector<TestResult> results;
    for(int i = 0; i < 5; i ++){
        for( int j = 0; j < 6; j ++){
           TestResult t(i, j+100);
           results.push_back(t);
        }
    }
    map<int, double> x = calculateFinalScores(results);
    map<int, double>::iterator it;
    for(it = x.begin(); it!= x.end(); it ++){
        cout << it->first << " " << it->second << endl;
    }
    return 0;
}
