vector<int>idx[26];
for(int i=0;i<a.length();i++)
{
  idx[a[i]-'A'].push_back(i);
}
int ans=1;
int curr=-1;
for(int i=0;i<s.length();i++)
{
  if(idx[s[i]-'A'].size()==0)
  {
  ans=-1;
  break;
  }
  vector<int>::iterator

  it=upper_bound(idx[s[i]-'A'].begin(),idx[s[i]-'A'].end(),curr);

  if(it!=idx[s[i]-'A'].end())
  {
  curr=*(it);
  }
  else
  {
  ans++;
  curr=idx[s[i]-'A'][0];
  }
}
public class GoogleQuestion {
  
}
