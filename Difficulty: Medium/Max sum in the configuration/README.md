<h2><a href="https://www.geeksforgeeks.org/problems/max-sum-in-the-configuration/1?itm_source=geeksforgeeks">Max sum in the configuration</a></h2><h3>Difficulty Level : Difficulty: Medium</h3><hr><div class="problems_problem_content__Xm_eO"><p><span style="font-size: 18px;">Given an integer array(0-based indexing) <strong>arr[]</strong><strong>. </strong>Find&nbsp;the <strong>maximum</strong> value of the sum of<strong> i*arr[i] </strong>for all <strong>0 &lt;= i &lt;= arr.size()-1</strong>,<strong>&nbsp;</strong>where&nbsp;<strong>arr</strong><strong>[i]</strong> is the element at index <strong>i </strong>in the arr[]. The only operation allowed is to <strong>rotate(clockwise or counterclockwise)</strong> the array any number of times.</span></p>
<p><span style="font-size: 18px;"><strong>Examples :</strong></span></p>
<pre><span style="font-size: 18px;"><strong>Input: </strong>arr[] = [8, 3, 1, 2]
<strong>Output: </strong>29<strong>
Explanation: </strong>Out of all the possible configurations by rotating the elements: arr[] = [3, 1, 2, 8] here (3*0) + (1*1) + (2*2) + (8*3) sum is maximum i.e. 29.<br></span></pre>
<pre><span style="font-size: 14pt;"><strong>Input: </strong>arr[] = [1, 2, 3]
<strong>Output: </strong>8<strong>
Explanation: </strong>Out of all the possible configurations by rotating the elements: arr[] = [1, 2, 3] here (1*0) + (2*1) + (3*2) sum is maximum i.e. 8.</span></pre>
<pre><span style="font-size: 14pt;"><strong>Input: </strong>arr[] = [4, 13]
<strong>Output: </strong>13</span></pre>
<p><span style="font-size: 18px;"><strong>Constraints:</strong><br>1&lt;=arr.size()&lt;=10<sup>4</sup><br>1&lt;=arr[i]&lt;=20</span></p></div><p><span style=font-size:18px><strong>Company Tags : </strong><br><code>Amazon</code>&nbsp;<br><p><span style=font-size:18px><strong>Topic Tags : </strong><br><code>Arrays</code>&nbsp;<code>Data Structures</code>&nbsp;<code>Mathematical</code>&nbsp;