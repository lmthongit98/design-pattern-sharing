package com.tma.sharing.creationals.abstractfactory;

/**
 * The main point regarding Abstract Factory pattern is that,
 * this pattern creates a family of related objects that have different parent class or interface (Nokia and Apple).
 */
public interface MobileFactory {
    Nokia createNokiaMobile();
    Apple createAppleMobile();
}
