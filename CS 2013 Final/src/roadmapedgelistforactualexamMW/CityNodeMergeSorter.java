package roadmapedgelistforactualexamMW;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;



public class CityNodeMergeSorter {

	
	public List<CityNode> getSortedList(Set<CityNode> nodes){
		CityNode middle = getMiddle(nodes);
		//CityNode next ;
		//  middle.setNext(null);
		 

		  CityNode left = (CityNode) getSortedList(nodes);
		//  CityNode right = (CityNode) getSortedLinkList();
		 
		  List<CityNode> sortedList = null;// = mergeTwoListIterative(left, right);
		 
		  return sortedList;
	}
	
	private Set<CityNode> mergeTwoListIterative(CityNode leftStart, CityNode rightStart) {
		 
		  CityNode merged = null;
		  CityNode temp = null;
		 
		  CityNode lastAddedNode = null;
		 
		  while(leftStart != null && rightStart != null){
		 
		   if(leftStart.compareTo(rightStart) > 0){
		    temp = new CityNode(rightStart.getCityName());
		    rightStart = new CityNode(rightStart.getCityName());
		 
		   }
		   
		   else{
		    temp = new CityNode(leftStart.getCityName());
		    leftStart = new CityNode(leftStart.getCityName());
		   } 
		 
		   if(merged==null){
		    merged=temp;
		   }
		   
		   else{
//		    lastAddedNode;     
		   }
		   
		   lastAddedNode=temp;
		   
		  }
		 
		  if(leftStart!=null){
//		   set left start;
		  }else{
//		   set right start;
		  }
		   
		  return (Set<CityNode>) merged;
		 }
	
	private CityNode getMiddle(Set<CityNode> nodes) {
		  if(nodes == null){
		   return (CityNode) nodes;
		  }
		 
		  CityNode pointer1 = (CityNode) nodes;
		  CityNode pointer2 = (CityNode) nodes;
		   
		//  while(pointer2 != null && pointer2.getNext() != null && pointer2.getNext().getNext() != null){
		   //set pointer 1 to startNode +1
			 //pointer 2 to startnode +2;  
		 
		//  }
		  return pointer1;
		 }
}
