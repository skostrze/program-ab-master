package org.alicebot.ab;
/* Program AB Reference AIML 2.0 implementation
        Copyright (C) 2013 ALICE A.I. Foundation
        Contact: info@alicebot.org

        This library is free software; you can redistribute it and/or
        modify it under the terms of the GNU Library General Public
        License as published by the Free Software Foundation; either
        version 2 of the License, or (at your option) any later version.

        This library is distributed in the hope that it will be useful,
        but WITHOUT ANY WARRANTY; without even the implied warranty of
        MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
        Library General Public License for more details.

        You should have received a copy of the GNU Library General Public
        License along with this library; if not, write to the
        Free Software Foundation, Inc., 51 Franklin St, Fifth Floor,
        Boston, MA  02110-1301, USA.
*/

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Nodemapper data structure.  In order to minimize memory overhead this class has no methods.
 * Operations on Nodemapper objects are performed by NodemapperOperator class
 */
public class Nodemapper {
/*    public static int idCnt=0;
    public int id;*/
    public Category category = null;
    public int height = MagicNumbers.max_graph_height;
    public StarBindings starBindings = null;
    public HashMap<String, Nodemapper> map = null;
    public String key = null;
    public Nodemapper value = null;
    public boolean shortCut = false;
    public ArrayList<String> sets;
    public ArrayList<String> dics;

    
    /*    public Nodemapper () {
        id = idCnt++;
    }*/

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + (this.category != null ? this.category.hashCode() : 0);
        hash = 71 * hash + this.height;
        hash = 71 * hash + (this.starBindings != null ? this.starBindings.hashCode() : 0);
        hash = 71 * hash + (this.map != null ? this.map.hashCode() : 0);
        hash = 71 * hash + (this.key != null ? this.key.hashCode() : 0);
        hash = 71 * hash + (this.value != null ? this.value.hashCode() : 0);
        hash = 71 * hash + (this.shortCut ? 1 : 0);
        hash = 71 * hash + (this.sets != null ? this.sets.hashCode() : 0);
        hash = 71 * hash + (this.dics != null ? this.dics.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Nodemapper other = (Nodemapper) obj;
        if (this.height != other.height) {
            return false;
        }
        if (this.shortCut != other.shortCut) {
            return false;
        }
        if ((this.key == null) ? (other.key != null) : !this.key.equals(other.key)) {
            return false;
        }
        if (this.category != other.category && (this.category == null || !this.category.equals(other.category))) {
            return false;
        }
        if (this.starBindings != other.starBindings && (this.starBindings == null || !this.starBindings.equals(other.starBindings))) {
            return false;
        }
        if (this.map != other.map && (this.map == null || !this.map.equals(other.map))) {
            return false;
        }
        if (this.value != other.value && (this.value == null || !this.value.equals(other.value))) {
            return false;
        }
        if (this.sets != other.sets && (this.sets == null || !this.sets.equals(other.sets))) {
            return false;
        }
        if (this.dics != other.dics && (this.dics == null || !this.dics.equals(other.dics))) {
            return false;
        }
        return true;
    }

    
 }


