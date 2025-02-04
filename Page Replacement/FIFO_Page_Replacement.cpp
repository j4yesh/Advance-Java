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
    
    queue<int>st;

    for(int i=0;i<n;i++){
        if(ifind(frame,demand[i])){
            printFrame(frame);
            cout<<" Hit "<<demand[i]<<endl;
        }else{
            if(st.size()<framesize){
                st.push(st.size());
                frame[st.size()-1]={ -1 ,demand[i]};
                printFrame(frame);
                cout<<" Fault "<<demand[i]<<endl;
                continue;
            }
            int pick =st.front();
            st.pop();
            frame[pick]={ -1 ,demand[i]};
            st.push(pick);
            printFrame(frame);
            cout<<" Fault "<<demand[i]<<endl;
        }
    }

    return 0;
}
