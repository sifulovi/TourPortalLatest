<g:each in="${tourPackages}" var="tourPackage">
    <g:render template="form" model="[tourPackage:tourPackage]"/>
</g:each>
<g:render template="form"/>