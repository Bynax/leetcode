#include<iostream>
#include<vector>
#include<string>
using namespace std;
bool isValid(string s){
    if(atoi(s.c_str()) > 255 || s[0] == '0' && s.size() > 1)
        return false;
    return true;
}
int restoreIpAddresses(const string &s) {
    vector<string> res;
    int len = s.size();
    for(int i=1; i<4 && i<len-2; i++){
        for(int j=i+1; j<i+4 && j<len-1; j++){
            for(int k=j+1; k<j+4 && k<len; k++){
                if(len-k>3)
                    continue;
                string a = s.substr(0, i);
                string b = s.substr(i, j-i);
                string c = s.substr(j, k-j);
                string d = s.substr(k, len-k);
                if(isValid(a) && isValid(b) && isValid(c) && isValid(d))
                {
                    res.push_back(a+'.'+b+'.'+c+'.'+d);
                    cout<<"hello"<<endl;

                }
                    
            }
        }
    }
    cout<<res.size();
    return res.size();
}
int main()
{
    string s;
    cin>>s;
    printf("%d",restoreIpAddresses(s));
    
}