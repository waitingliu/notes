#DCL(Double Check Lock)֮����ȫ����

##����ȫ����

������publish��һ������ʹ�����ܹ��ڵ�ǰ������֮��Ĵ�����ʹ��
��ȫ������ȷ���������ú�״̬�������߳���ȷ�ɼ�

![](img/osp.gif)

##DCL

����������˫������飨Ҳ�ж��̵߳���ģʽ����һ��ƭ�˵İ�Ϸ��������֧��lazy��ʼ����ͬʱ�������ʹ��ͬ����

˫�������������£�

```java
private static Something instance = null;

public Something getInstance() {
  if (instance == null) {
    synchronized (this) {
      if (instance == null)
        instance = new Something();
    }
  }
  return instance;
}
```

ʵ���ϣ�������������������

ԭ�򣺳�ʼ��ʵ������ new Something()��ʵ���ֶε�д����� instance = XXX ���ܰ�˳����У�Ҳ���ܵߵ������һ���̵߳���getInstance()ʱ�ܵõ�һ���ǿյĶ������ã����ǵõ��Ķ������ò��ܱ�֤��ʵ����ʼ���õġ�

����취1����Instance��Ϊ���ɱ���󣬱��������ֶζ���final.

����취2��ʹ��volatile�ؼ���
JSR-133�����µ�JMM����ǿ��volatile������
�µ����壺
	*�������һ��volatile��д������֮ǰ�Ķ�д�����������š���д֮ǰ��
	*��volatile�Ķ�����Ҳ����������Ķ�д�������š�����֮��

����A��

```java
class T {
    private static volatile T instance;
    public M m; // ����û��final����
 
    public static T getInstance() {
        if (null == instance) {
            synchronized (T.class) {
                if (null == instance) {
                    instance = new T();
                    instance.m = new M();
                }
            }
        }
        return instance;
    }
}
```

����B��

```java
class T {
    private static volatile T instance;
    public M m; // ����û��final����
 
    public static T getInstance() {
        if (null == instance) {
            synchronized (T.class) {
                if (null == instance) {
                    T temp = new T();
                    temp.m = new M();
                    instance = temp;
                }
            }
        }
        return instance;
    }
}
```

A��B�ĸ����԰�ȫ��������

A���ܣ� ��һ���߳�ִ�����һ��`instance = new T();`ʱ�������Ѿ��ǿգ���ʱ�����һ���̵߳���getInstance()�ͻ�õ�һ��û�����ü���ʼ��m�ֶεĲ������Ķ���
volatile���Ա�֤`new T()` happens before `instance = new T()` ���ǲ��ܱ�֤�߳�X�и�instance�����Ը���ֵnew M()�ܱ��߳�Y������

B�ܣ� ����B���ж���ʵ����ʼ���Ĳ������� `instance=temp;` ������volatile���ε�����instance��д������֮ǰ����Щ�����Ľ�����ǡ��ɼ��ġ���

##ʹ��˫���������ʵ�ֵ���ģʽ����һ���õ�ѡ��

DCL�ĳ�����Ϊ�˱������ʹ��ͬ�������������⡣���µ�JMM�У�ʹ��volatile��һ�����ܿ���������һЩ�������Ż�����

ʹ��IODH(Initialization On Demand Holder)��ʵ�ֶ��߳�ģʽ�µĵ�������׶���

```java
class T {
    public final M m = new M();
	
	//��һ��static�ڲ���
    private static class LazyHolder {
        public static T instance = new T();
    }
 
    public static T getInstance() {
        return LazyHolder.instance;
    }
}
```

��δ�������ȷ�ģ���Ϊ��ʼ������static�ֶ�����֤�ġ�
���һ���ֶ�������static��ʼ���У������������������߳���˵��������ȷ�ı�֤���Ŀɼ��Եġ�



