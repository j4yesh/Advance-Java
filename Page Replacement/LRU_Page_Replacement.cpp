#include <bits/stdc++.h>
using namespace std;


int findOldest(vector<pair<int,int>>&allocated){
     int miin=allocated[0].second,idx=0;
    for(int i=0;i<allocated.size();i++){
        if(allocated[i].second<miin){
            idx=i;
            miin=allocated[i].second;
        }
    }
    return idx;
}

void printFrame(vector<pair<int,int>>&vec){
    for(auto it: vec){
        cout<<it.second<<" ";
    }
}

bool ifind(vector<pair<int,int>> &q,int key){
    for(auto it:q){
        if(it.second==key)return true;
    }
    return false;
}

int main() {
    vector<int> demand = { 1,2,4,1,2,3,4,5,3,2,3,3,4,2};
    int cnt = 0;
    int n=demand.size();
    int framesize=3;
    vector<int>allocated(n,-1);
    vector<pair<int,int>> frame(framesize,{-1,-1});
    
    for(int i=0;i<n;i++){
        if(ifind(frame,demand[i])){
            printFrame(frame);
            cout<<" Hit "<<demand[i];
            cout<<endl;
        }else{
            int idx = findOldest(frame);
            cnt++;
            frame[idx]={cnt,demand[i]};
            printFrame(frame);
            cout<<" Fault "<<demand[i];
            cout<<endl;
        }
    }

    return 0;
}
