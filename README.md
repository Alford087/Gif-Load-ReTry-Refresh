# Gif-Load-ReTry-Refresh

[![](https://jitpack.io/v/NoEndToLF/Gif-Load-ReTry-Refresh.svg)](https://jitpack.io/#NoEndToLF/Gif-Load-ReTry-Refresh)

**Gif-Load-ReTry-Refresh**��ֻ��Ҫһ��Gifͼ��һ�д���֧�ֳ��μ��أ����Լ��أ����غ��ٴ�ˢ��
 
- **ԭ��** ������View������Framelayout�ж�̬������Ƴ����ز��֣����������ڰ󶨣������ڴ�й©��
- **����** ��Ŀǰ֧����Activity��Fragment��ʹ�ã�֧���κη�ʽʵ�ֵĳ���ʽ״̬����͸��״̬����;
- **��װ** ���ӿڻ����ã�֧��MVP�ṹ��ʹ�á�

-------------------
# ��ʾ��Ŀ
 &nbsp&nbsp&nbsp&nbsp&nbsp��Activity�м��سɹ���Ȼ���ٴμ���ˢ��&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp��Activity�м���ʧ�ܣ�Ȼ�����Լ��أ����سɹ���ˢ�¼���
 ![activity_success](https://github.com/NoEndToLF/Gif-Load-ReTry-Refresh/blob/master/imgs/activity_success.gif?raw=true)&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp![activity_success](https://github.com/NoEndToLF/Gif-Load-ReTry-Refresh/blob/master/imgs/activity_failed.gif?raw=true)  
   
  <br />&nbsp&nbsp&nbsp&nbsp&nbsp��Fragment�м��سɹ���Ȼ���ٴμ���ˢ��&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp��Fragment�м���ʧ�ܣ�Ȼ�����Լ��أ����سɹ���ˢ�¼���
 <br />![fragment_success]( https://github.com/NoEndToLF/Gif-Load-ReTry-Refresh/blob/master/imgs/fragment_success.gif?raw=true)&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp![fragment_failed]( https://github.com/NoEndToLF/Gif-Load-ReTry-Refresh/blob/master/imgs/fragment_failed.gif?raw=true)


[TOC]
## ��������
### ����
Step 1. Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
Step 2. Add the dependency

	dependencies {
	        compile 'com.github.NoEndToLF:Gif-Load-ReTry-Refresh:1.1.0'
	}
### ��������
| ����      |����  | ����  |
| :-------- | --------:| :--: |
| setGif| R.drawable.* |  ����ҳ���Gifͼ   |
| setBackgroundColor  | R.color.* |  ����ҳ�����屳����ɫ   |
| setBtnNormalColor|    R.color.* |  ����ҳ�水ťδ����ʱ����ɫ|
| setBtnPressedColor|    R.color.* |  ����ҳ�水ť����ʱ����ɫ|
| setBtnBorderColor|    R.color.* |  ����ҳ�水ť�߿����ɫ|
| setBtnTextColor|    R.color.* |  ����ҳ�水ť���ֵ���ɫ|
| setBtnRadius|    Float |  ����ҳ�水ť��Բ�ǻ���|
| setBtnText|    String |  ����ҳ�水ť����ʾ����|
| setLoadText|    String | ���ڼ����е���ʾ����|
| setLoadAndErrorTextColor|    R.color.*  | ����ҳ�����ʾ���ֺͼ���ʧ����ʾ���ֵ���ɫ|

### ʾ�����룬������Application����ɳ�ʼ������
``` java
LoadRetryRefreshConfig config=new LoadRetryRefreshConfig();
        config.setBackgroundColor(R.color.white);
        config.setBtnNormalColor(R.color.blue_normal);
        config.setBtnPressedColor(R.color.blue_press);
        config.setBtnBorderColor(R.color.oringe_normal);
        config.setBtnRadius(10f);
        config.setBtnText("������¼���");
        config.setLoadText("���Լ���2����...");
        config.setBtnTextColor(R.color.white);
        config.setLoadAndErrorTextColor(R.color.gray);
        config.setGif(R.drawable.zhufaner);
        LoadReTryRefreshManager.getInstance().setLoadRetryRefreshConfig(config);
```
## ��<span id="activity">Activity</span>��ʹ��

### �����У�����Toolbar�µ���Ҫ���ص������������һ��FrameLayout��[Ϊ����Ҫ������](#reason)�����磺
``` java
<LinearLayout android:layout_width="match_parent"
    android:layout_height="match_parent"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:orientation="vertical"
    xmlns:android="http://schemas.android.com/apk/res/android">
    <android.support.v7.widget.Toolbar
        app:contentInsetStart="0dp"
        android:layout_width="match_parent"
        android:layout_height="?attr/actionBarSize"
        android:gravity="center_vertical"
        android:id="@+id/toolbar"
        android:background="@color/color_toolbar"
        >
        <FrameLayout
            android:layout_width="match_parent"
            android:layout_height="match_parent">
            
            **********************************
            **********************************
            ������ݲ��֣���Linearlayout��
            **********************************
            **********************************
            
             </FrameLayout>
</LinearLayout>
```
### ������
#### �������
| ����      |����  | ����  |
| :-------- | --------:| :--: |
| register| Activity��LoadRetryRefreshListener |  ע��   |
| startLoad| Activity |  ��ʼ����   |
| unRegister|    Activity  |  �����|
| onLoadSuccess|    Activity��ShowRefreshViewListener  |  �رռ���View��ˢ��ʱ��Dialog������ˢ�µ�<br />(�Զ��ж�)|
| onLoadFailed|    Activity��ShowRefreshViewListener|  ����رռ���View��ˢ��ʱ��Dialog������ˢ�µ�<br />(�Զ��ж�)��|
####1��ע�ᣬһ����onCreate�е���
``` java
LoadReTryRefreshManager.getInstance().register(this, new LoadRetryRefreshListener() {
            @Override
            public void loadAndRetry() {
            //ִ�������������
            //dosomething();
            }

            @Override
            public void showRefreshView() {
            //��ʾ��ˢ��ʱ�ļ���View����Dialog������ˢ�µ�
                
            }
        });           
```
####2����ʼ���أ������ж��ǳ��μ��ػ��Ǽ������ˢ�£����Զ������жϣ����μ��غ�ˢ�¶����ø÷���
``` java
LoadReTryRefreshManager.getInstance().startLoad(this);          
```
####3�����ؽ���ص������������ɹ���ʧ�ܵĻص��м�����ؽ���ص�
``` java
            @Override
            public void onSuccess(Integer value) {
            //���سɹ���Ҫ������.....
            
                //���ؽ���ص�
                LoadReTryRefreshManager.getInstance().onLoadSuccess(FailedActivity.this, 
                new ShowRefreshViewListener() {
                    @Override
                    public void colseRefreshView() {
                     //�ر����ˢ��View,��Dialog������ˢ�µ�  
                    }
                });
            }

            @Override
            public void onFailed(Throwable e) {
            //����ʧ����Ҫ������.....
            
                //���ؽ���ص�
                LoadReTryRefreshManager.getInstance().onLoadFailed(FailedActivity.this, 
                e.getMessage(), new ShowRefreshViewListener() {
                    @Override
                    public void colseRefreshView() {
                       //�ر����ˢ��View,��Dialog������ˢ�µ�
                    }
                });
            }        
```
####4������󶨣�����ֱ��д��BaseActivity��onDestory�����У����Զ��ж�Ȼ����н��
``` java
@Override
    protected void onDestroy() {
        super.onDestroy();
        LoadReTryRefreshManager.getInstance().unRegister(this);
    }
```
##��Fragment��ʹ��
### ͬ[Activity](#activity)��ʹ��һ�£�����Toolbar�µ���Ҫ���ص������������һ��FrameLayout��[Ϊ����Ҫ������](#reason)��
### ������
#### �������
| ����      |����  | ����  |
| :-------- | --------:| :--: |
| register| Fragment��View��LoadRetryRefreshListener |  ע��<br />(ViewΪFragment��onCreateView�з��ص�View)   |
| startLoad| Fragment|  ��ʼ����   |
| unRegister|    Fragment|  �����|
| onLoadSuccess|    Activity��ShowRefreshViewListener  |  �رռ���View��ˢ��ʱ��Dialog������ˢ�µ�<br />(�Զ��ж�)|
| onLoadFailed|    Activity��ShowRefreshViewListener|  ����رռ���View��ˢ��ʱ��Dialog������ˢ�µ�<br />(�Զ��ж�)��|
####1��ע�ᣬһ����onCreateView�е���
``` java
LoadReTryRefreshManager.getInstance().register(this, contentView,new LoadRetryRefreshListener() {
            @Override
            public void loadAndRetry() {
            //ִ�������������
            //dosomething();
            }

            @Override
            public void showRefreshView() {
            //��ʾ��ˢ��ʱ�ļ���View����Dialog������ˢ�µ�
                
            }
        });           
```
####2��ʼ���أ������ж��ǳ��μ��ػ��Ǽ������ˢ�£����Զ������жϣ����μ��غ�ˢ�¶����ø÷���
``` java
LoadReTryRefreshManager.getInstance().startLoad(this);          
```
####3�����ؽ���ص������������ɹ���ʧ�ܵĻص��м�����ؽ���ص�
``` java
            @Override
            public void onSuccess(Integer value) {
            //���سɹ���Ҫ������.....
            
                //���ؽ���ص�
                LoadReTryRefreshManager.getInstance().onLoadSuccess(FailedActivity.this, 
                new ShowRefreshViewListener() {
                    @Override
                    public void colseRefreshView() {
                     //�ر����ˢ��View,��Dialog������ˢ�µ�  
                    }
                });
            }

            @Override
            public void onFailed(Throwable e) {
            //����ʧ����Ҫ������.....
            
                //���ؽ���ص�
                LoadReTryRefreshManager.getInstance().onLoadFailed(FailedActivity.this, 
                e.getMessage(), new ShowRefreshViewListener() {
                    @Override
                    public void colseRefreshView() {
                       //�ر����ˢ��View,��Dialog������ˢ�µ�
                    }
                });
            }        
```
####4������󶨣�����ֱ��д��BaseFragment��onDestroyView�����У����Զ��ж�Ȼ����н��
``` java
@Override
    public void onDestroyView() {
        super.onDestroyView();
        LoadReTryRefreshManager.getInstance().unRegister(this);
    }
```




## <span id="reason">Ϊ�α����ڲ�������һ��FrameLayout</span>
ĿǰΪ����4.4��5.0��6.0��7.0�����ϵİ汾��ʵ�ֳ���ʽ״̬��������͸��ʽ״̬����ʵ�ַ�ʽ��Ҫ�ڵͰ汾��������ͬ���е��Ǹ�Toolbar��һ��PaddingTop������StatusBar�ĸ߶ȣ��е�������ȫ��StatusBar͸����Ȼ���ٶ�̬����һ����Сһ�µ�View��ռλ���ﵽ����״̬����ɫ��Ŀ�ģ���ˣ������������DecorView����������ز��֣����Կ��Ƽ���ҳ���MarginTop�����ܻ��ڸǵ�Toolbar����ˣ��˶�����Σ��ڲ�������Ҫ���صĲ��ְ�һ��FrameLayout����ͨ���ݹ�View�����ҵ���Ҫ��Ӽ��ز��ֵĵط������ж�̬���롣����Ȼ����и��õ��뷨��ǿ�һ�ӭIssues��


## �����뽨��
- ���䣺<static_wxy@foxmail.com>

---------
