package com.example.demo.aop;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

// Aspet用のアノテーション2つ必須
// @Aspect→このクラスがAspectであることを示す
// @Component→Aspect自体をBean化してDIコンテナで管理するために必要なアノテーション
@Aspect
@Component
public class LoggingAspect {
	
	// 全ての型でcom.example.demo.service配下の全てのクラスの全てのメソッドが対象
	// 引数は0個～
	@Before("execution(* com.example.demo.repository.*.*(..))")
	// joinPoint→com.example.demo.service.*.*
    public void logBefore(JoinPoint joinPoint) {
        outputLog("メソッド開始", joinPoint);
    }
    
	// メソッドが正常終了したとき
    @AfterReturning("execution(* com.example.demo.repository.*.*(..))")
    public void logAfter(JoinPoint joinPoint) {
    	outputLog("メソッド終了", joinPoint);
    }
    
    // 共通ログ出力メソッド
    private void outputLog(String str, JoinPoint joinPoint) {
    	// 現在時刻文字列取得
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String strNow = LocalDateTime.now().format(formatter);
        // クラス名・メソッド名取得
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        // ログ表示
        System.out.println(
        		strNow + " : " + str + " : " + 
        		className + "." + methodName + "()"		);
    }

}
