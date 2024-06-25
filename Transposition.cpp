
#include<bits/stdc++.h>

using namespace std;


int main(){

    string plain,key;
    cin>>plain>>key;

    int pl=plain.length();
    int kl=key.length();
    int x;
    char tk[kl];

    if(pl%kl==0){
        x=pl/kl;
    }
    else{
        int n=pl%kl;
        n=kl-n;
        for(int i=1;i<=n;i++){
            plain=plain+'*';
        }
        pl=plain.length();
        x=pl/kl;


    }


        cout<<plain<<endl;
     char m1[x][kl],m2[x][kl];
    int t1 = 0;
    for(int i=0; i<x; i++){
        for(int j=0; j<kl; j++){
            m1[i][j] = plain[t1];
            t1++;
        }
    }
    cout << "1st matrix - " << endl;
    for(int i=0; i<kl; i++){
        cout << key[i] << " ";
        tk[i] = key[i];
    }
    cout << endl;
    for(int i=0; i<kl; i++){
        cout << '_' << " ";
    }
    cout << endl;
    for(int i=0; i<x; i++){
        for(int j=0; j<kl; j++){
            cout << m1[i][j] << " ";
        }
        cout << endl;
    }
    cout << endl;

    sort(tk,tk+kl);
    string cipher;

    int t=kl,j=0;
    while(!t==0){
        for(int i=0;i<kl;i++){
            if(tk[j]==key[i]){
                for(int k=0;k<x;k++){
                    cipher=cipher+m1[k][i];
                }
                break;
            }
        }
        j++;
        t--;
    }
    cout<<cipher<<endl;


    int tt=cipher.length(),index=0;
    char m3[x][kl];

    j=0;
    while(tt!=0){
        for(int i=0;i<kl;i++){
            if(key[i]==tk[j]){
                for(int k=0;k<x;k++){
                    m2[k][i]=cipher[index];
                    index++;
                    tt--;
                }
                j++;
                cout<<endl;
                break;
            }

        }
    }

    cout<<"Decrypted matrix - "<<endl;

    for(int i=0;i<x;i++){
        for(int j=0;j<kl;j++){
            cout<<m2[i][j]<<" ";
        }
        cout<<endl;
    }

}
