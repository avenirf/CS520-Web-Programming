<li>Description</li>
</ul>

<p>In this exam you are going to implement some new functions in CSJobs. You should work on an unmodified copy of CSJobs checked out from the Subversion repository at <tt>svn://sun.calstatela.edu/csjobs/trunk</tt>. To submit your work, please create a zip file of the project folder and upload the file to <a href="/department/cs/">CSNS</a>. The zip file should only include <tt>pom.xml</tt>, and two folder <tt>src/</tt> and <tt>.svn/</tt>.</p>

<hr />
<p>1. (15pt) Admin Home Page</p>

<p>List all the job positions on the admin home page. For each job position, display the title, publish date, and close date. For example:</p>

<p style="margin-left: 40px;"><a href="#">Create New Job</a></p>

<div style="margin-left: 40px;">
<table border="1" cellpadding="2" cellspacing="2">
	<thead>
		<tr>
			<th scope="col">Job</th>
			<th scope="col">Publish Date</th>
			<th scope="col">Close Date</th>
			<th scope="col">Operations</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td><a href="#">Tenure-Track Faculty Position (Start Fall 2016)</a></td>
			<td style="text-align: center;">8/7/2015</td>
			<td style="text-align: center;">&nbsp;</td>
			<td style="text-align: center;"><a href="#">Edit</a></td>
		</tr>
		<tr>
			<td><a href="#">Tenure-Track Faculty Position (Start Fall 2015)</a></td>
			<td style="text-align: center;">8/7/2015</td>
			<td style="text-align: center;">&nbsp;</td>
			<td style="text-align: center;"><a href="#">Edit</a></td>
		</tr>
	</tbody>
</table>
</div>

<p>The dates should be in the format <tt>M/d/yyyy</tt>, and the jobs should be listed in the reverse order in which they were created, i.e. the most recently created job should be displayed at the top of the list.</p>

<p>2. (15pt) View Job Position</p>

<p>A user can click on the title of a job position and see the details of the position, which include the job title, description, publish date, close date, <em>as well as the names of the review committee chair and the review committee members</em>.</p>

<p>3. (50pt) Create New Job Position</p>

<p>Clicking on <em>Create New Job</em> allows a user to create a new job position. For example:</p>

<div style="margin-left: 40px;">
<table border="1" cellpadding="2" cellspacing="2">
	<tbody>
		<tr>
			<th style="text-align: right;">Title</th>
			<td><input name="title" type="text" /></td>
		</tr>
		<tr>
			<th style="text-align: right;">Description</th>
			<td><textarea cols="60" name="description" rows="5"></textarea></td>
		</tr>
		<tr>
			<th style="text-align: right;">Publish Date</th>
			<td><input name="publishDate" type="text" /></td>
		</tr>
		<tr>
			<th style="text-align: right;">Close Date</th>
			<td><input name="closeDate" type="text" /></td>
		</tr>
		<tr>
			<th style="text-align: right;">Committee Chair</th>
			<td><select name="chair"><option>Reviewer1 User</option><option>Reviewer2 User</option><option>Reviewer3 User</option><option>Reviewer4 User</option> </select></td>
		</tr>
		<tr>
			<th style="text-align: right;">Committee Members</th>
			<td><input name="member" type="checkbox" value="Reviewer1 User" /> Reviewer1 User<br />
			<input name="member" type="checkbox" value="Reviewer2 User" /> Reviewer2 User<br />
			<input name="member" type="checkbox" value="Reviewer3 User" /> Reviewer3 User<br />
			<input name="member" type="checkbox" value="Reviewer4 User" /> Reviewer4 User</td>
		</tr>
		<tr>
			<td colspan="2"><input name="create" type="submit" value="Create" /></td>
		</tr>
	</tbody>
</table>
</div>

<p>Note that</p>

<ul>
	<li>Publish date and close date are optional. If empty, the corresponding date field in the Job object should be set to NULL.</li>
	<li>The input format for the date fields is <tt>M/d/yyyy</tt>, e.g. <tt>8/31/2015</tt>.</li>
	<li>The reviewers shown in the form must be retrieved from the database. In other words, you cannot just hard-code Reviewer1-4 in the JSP.</li>
	<li>The committee chair is also a committee member. If a reviewer is selected as the committee chair but is not checked as one of the committee members, the system should automatically add that reviewer as a committee member.</li>
</ul>

<p>4. (20pt) Edit Job Position</p>

<p>Clicking on <em>Edit</em> allows a user to edit a job position (including changing its review committee chair and committee members). The edit form should be pre-filled with the current information of the job position. Other requirements are the same as in creating a job position.</p>

<p>[Notes]</p>

<p>If you change the database schema, don&#39;t forget to update the database scripts <tt>csns-create.sql</tt> and <tt>csns-drop.sql</tt>.</p>

<p>Input validation is not required, and other than login and logout, you don&#39;t need to worry about security either.</p>


</div></div>