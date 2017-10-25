package com.behavioral.model.templatemethodmodel;
/*抽象模板(Abstract Template)角色有如下责任：
定义了一个或多个抽象操作，以便让子类实现。这些抽象操作叫做基本操作，它们是一个顶级逻辑的组成步骤。
定义并实现了一个模板方法。这个模板方法一般是一个具体方法，它给出了一个顶级逻辑的骨架，而逻辑的组成步骤在相应的抽象操作中，推迟到子类实现。顶级逻辑也有可能调用一些具体方法。*/
public abstract class Account {
	 /**
     * 模板方法，计算利息数额
     * @return    返回利息数额
     */
    public final double calculateInterest(){
        double interestRate = doCalculateInterestRate();
        String accountType = doCalculateAccountType();
        double amount = calculateAmount(accountType);
        return amount * interestRate;
    }
    
    /**
     * 抽象方法：一个抽象方法由抽象类声明，由具体子类实现。在Java语言里抽象方法以abstract关键字标示。
     * 基本方法留给子类实现
     */
    protected abstract String doCalculateAccountType();
    /**
     * 抽象方法：一个抽象方法由抽象类声明，由具体子类实现。在Java语言里抽象方法以abstract关键字标示。
     * 基本方法留给子类实现
     */
    protected abstract double doCalculateInterestRate();
    /**
     * 具体方法：一个具体方法由抽象类声明并实现，而子类并不实现或置换。
     * 基本方法，已经实现
     */
    private double calculateAmount(String accountType){
        /**
         * 省略相关的业务逻辑
         */
        return 7243.00;
    }
    
    /**
     * 钩子方法：一个钩子方法由抽象类声明并实现，而子类会加以扩展。通常抽象类给出的实现是一个空实现，作为方法的默认实现。
     * 基本方法(空方法)
     */
    protected void hookMethod(){}
}
