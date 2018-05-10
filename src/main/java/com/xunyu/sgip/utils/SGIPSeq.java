/**
 * COPYRIGHT (C) 2010 LY. ALL RIGHTS RESERVED.
 * <p>
 * No part of this publication may be reproduced, stored in a retrieval system,
 * or transmitted, on any form or by any means, electronic, mechanical, photocopying,
 * recording, or otherwise, without the prior written permission of 3KW.
 * <p>
 * Created By: zzqiang
 * Created On: 2013-10-17
 * <p>
 * Amendment History:
 * <p>
 * Amended By       Amended On      Amendment Description
 * ------------     -----------     ---------------------------------------------
 **/
package com.xunyu.sgip.utils;

/**
 * 命令循环序号 产生类
 * @author zzqiang
 *
 */
public class SGIPSeq {

    private static int MIN_SEQ = 0;

    private static int MAX_SEQ = Integer.MAX_VALUE;

    private static int CUR_SEQ = MIN_SEQ;

    public static synchronized int getSeq() {
        if (CUR_SEQ == MAX_SEQ) {
            CUR_SEQ = MIN_SEQ;
        }
        return CUR_SEQ++;
    }

}
