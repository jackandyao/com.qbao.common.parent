/**
 * 
 */
package com.qbao.recommend.util.TestInit;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shuaizhihu
 *
 * $LastChangedDate$
 * $LastChangedRevision$
 * $LastChangedBy$
 */
public class SpuInitUtil {
       
       public static List<Long> getSpuList(){
            List<Long> ids = new ArrayList<Long>();
            Long[] spuIds = new Long[]{628861L,628767L,628748L,628669L,628550L,628500L,628388L,628212L,628199L,628086L,628067L,628037L,628029L,627961L,627842L,627762L,627734L,627692L,627650L,627453L,627448L,627230L,627088L,627036L,627023L,626999L,626924L,626775L,626721L,626699L,626497L,626475L,626450L,626404L,626301L,626267L,626248L,626194L,626099L,626014L,625767L,625761L,625756L,625727L,625633L,625588L,625577L,625561L,625271L,625162L};
            for(Long id:spuIds){
                ids.add(id); 
            }
            return ids;
       }
}
