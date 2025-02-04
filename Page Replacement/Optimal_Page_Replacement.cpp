#include <bits/stdc++.h>
using namespace std;


int findOldest(vector<int>&allocated,vector<int>demand){
    unordered_set<int> sat; 
    for(auto it: allocated){
        sat.insert(it);
    }
    for(int i=0;i<allocated.size();i++){
        if(sat.find(allocated[i])!=sat.end()){
            return i;
        }
    }
    return -1;
}

int opti(vector<int>&allocated,vector<int>demand){
    unordered_map<int,int> sat; 
    for(int i=0;i<allocated.size();i++){
        sat[allocated[i]]=i;
    }
    for(int i=demand.size()-1;i>=0;i--){
        if(sat.find(demand[i])!=sat.end()){
            return i;
        }
    }
    return -1;
}

void printFrame(vector<int>&vec){
    for(auto it: vec){
        cout<<it<<" ";
    }
}

bool ifind(vector<int> &q,int key){
    for(auto it:q){
        if(it==key)return true;
    }
    return false;
}

int main() {
    vector<int> demand = { 1,2,4,1,2,3,4,5,3,2,3,3,4,2};
    int cnt = 0;
    int n=demand.size();
    int framesize=3;
    vector<int>allocated(n,-1);
    vector<int> frame(framesize,-1);
    
    queue<int>st;

    for(int i=0;i<n;i++){
        if(ifind(frame,demand[i])){
            printFrame(frame);
            cout<<" Hit "<<demand[i]<<endl;
        }else if(i<framesize){
            frame[i]=demand[i];
            printFrame(frame);
            cout<<" Fault "<<demand[i]<<endl;
        }
        else{
            int idx=findOldest(frame,demand);
            if(idx==-1){
                int idx = opti(frame,demand);
            }
                frame[idx]=demand[i];
                printFrame(frame);
                cout<<" Fault "<<demand[i]<<endl;
        }
    }

    return 0;
}
