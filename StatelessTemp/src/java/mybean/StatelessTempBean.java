/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mybean;

import javax.ejb.Stateless;

/**
 *
 * @author Study
 */
@Stateless
public class StatelessTempBean implements StatelessTempBeanRemote {
    private float c = 0.0f;
    @Override
    public float fahrenToCelcius(float f) {
        c = (f - 32) * 5f / 9f;
        return c;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
}
