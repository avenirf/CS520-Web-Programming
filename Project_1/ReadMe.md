<li>Description</li>
</ul>

<p>Package all the source files of your project into a zip file as you did in Homework 2 and upload the zip file to CSNS. Note that file uploading will be disabled automatically after 11:59PM of the due date, so please turn in your work on time.</p>

<hr />
<p>This assignment builds on top of your work in the previous assignments, <em>so make sure&nbsp;that all the functions from previous assignments work properly; otherwise you may not receive any credit</em>. All requirements from previous assignments still apply. In particular, all data must be stored in a database, and the server side must be implemented using Spring and Hibernate.</p>

<p>Continue your work in Homework 5 and implement the following functions in CSJobs:</p>

<p>1. (20pt) Admin Functions</p>

<p>Add the admin functions you implemented in the midterm to the project.</p>

<p>2. Applicant Functions</p>

<ul>
	<li>(25pt) Allow an applicant to upload CV, teaching statement, and research statement when applying for a position. All three fields should be considered optional.</li>
</ul>

<p style="margin-left: 40px;">You can decide whether to store the uploaded files in database or on disk. If you choose to store the uploaded files on disk, they must be stored under the <tt>/WEB-INF/files</tt> folder (including its subfolders) - there will be a -15pt penalty if you store files anywhere outside that folder.</p>

<p style="margin-left: 40px;">Regardless of whether you store the files in database or on disk, you must properly handle files with the same names. For example, two applicants may both upload files called <tt>cv.doc</tt>, and even the same applicant may upload two <tt>cv.doc</tt> to two different positions. Obviously uploaded files with the same name should not simply overwrite each other.</p>

<ul>
	<li>(15pt) When displaying an application, show the links to CV, teaching statement, and research statement if the applicant has uploaded them. Clicking on a link should open or download the uploaded file.</li>
</ul>

<p>3. Spring Security</p>

<p>Use Spring Security to implement the following security measures:</p>

<ul>
	<li>(20pt) Authentication: login and logout.</li>
	<li>(40pt) Authorization</li>
</ul>

<p>When it comes to authorization, in most case we want to control two types of access to the resources: <em>read</em> (e.g. view and display) and <em>write</em> (e.g. create, edit, and delete). In this exercise we will focus on two resources: job position and application.</p>

<p>Only administrators have write access to job positions. As for read access, everyone (including anonymous users) has read access to published job positions, with the exception that only administrators and reviewers can view the committee chair and committee members of each job position; only administrators can view unpublished job positions.</p>

<p>For applications,</p>

<ul>
	<li>Anonymous users (i.e. users who have not logged in) have no access to any application.</li>
	<li>Applicants have both read and write access to their own applications, but have no access to anybody else&#39;s application.</li>
	<li>Reviewers have read access to the applications that they review (i.e. they are on the review committee for the applied job position), but no access to other applications.</li>
	<li>Administrator have read access to all applications.</li>
</ul>

<p>For this exercise, please describe all the security measures you have implemented and how you implemented them in a text file <em>hw5.txt</em>, and submit the file together with the project zip file. There will be a minimum -30pt penalty if you do not submit this file.</p>

<p>[About Submission and Grading]</p>

<p>Up to +30pt extra credit will be given for good UI design.</p>

<p>Before submitting your work, commit all the changes to your Subversion repository and create a tag<em>.</em></p>

<p>To test your project, we will use the following SQL scripts in your zip file to create, populate, and then clear the database:</p>

<ul>
	<li>src/main/scripts/csjobs-create.sql</li>
	<li>src/main/scripts/csjobs-drop.sql</li>
</ul>
